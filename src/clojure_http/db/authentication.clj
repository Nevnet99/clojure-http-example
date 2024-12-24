(ns clojure-http.db.authentication
  (:require [clojure.java.jdbc :as jdbc]
            [buddy.hashers :as hashers]
            [clojure-http.db.core :as db]))

(defn unique-email? [email]
  (let [query "SELECT COUNT(*) AS count FROM users WHERE email = ?"
        result (jdbc/query db/database [query email])]
    (zero? (:count (first result)))))

(defn generate-hash [password] (hashers/derive password))

(defn password-match? [password {:keys [hash]}]
  (let [{:keys [valid]} (hashers/verify password hash)]
    valid))

;; Users

(defn insert-user [user]
  (jdbc/insert! db/database :users user))

(defn get-user [email]
  (let [query "SELECT * FROM users WHERE email = ?"
        result (jdbc/query db/database [query email])]
    result))


