(ns clojure-http.routes.authentication
  (:require [clojure-http.db.authentication :as auth]))

(defn login-handler [])

(defn logout-handler [])

(defn register-handler [req]
  (println req)
  (let [email (:email req)
        password (:password req)
        username (:username req)]
    (if (auth/unique-email? email)
      (let [hashed-password (auth/generate-hash password)]
        (auth/insert-user {:hash hashed-password :email email :username username})
        {:status 201 :body "User registered successfully"})
      {:status 400 :body "Email already in use"})))

(defn refresh [])
