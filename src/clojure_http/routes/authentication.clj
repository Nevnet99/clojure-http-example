(ns clojure-http.routes.authentication
  (:require [clojure-http.db.authentication :as auth]
            [clojure.data.json :as json]))

(defn login-handler [{:keys [body]}]
  (let [{:keys [email password]} (-> body slurp (json/read-str :key-fn keyword))
        user (auth/get-user email)]
    (println user)
    (if (seq user)
      (if (auth/password-match? password user)
        {:status 200 :body "Successful login"}
        {:status 400 :body "Invalid information"})
      {:status 400 :body "Invalid information"})))

;; (defn login-handler []
;;   (println-str "hey"))

(defn logout-handler [req])

(defn register-handler [{:keys [body]}]
  (let [body-str (slurp body) ;; Read the input stream into a string
        {:keys [email password username]} (json/read-str body-str :key-fn keyword)] ;; Parse the JSON
    (println "Parsed body:" {:email email :password password :username username})
    (if (and email password username)
      (if (auth/unique-email? email)
        (let [hashed-password (auth/generate-hash password)]
          (auth/insert-user {:hash hashed-password :email email :username username})
          {:status 201 :body "User registered successfully"})
        {:status 400 :body "Email already in use"})
      {:status 400 :body "Missing required fields"})))

(defn refresh [])
