(ns clojure-http.db.authentication
  (:require [clojure.java.jdbc :as jdbc]
            [buddy.hashers :as hashers]
            [clojure-http.db.core :as db]))

(defn unique-email? [email]
  (let [query "SELECT COUNT(*) AS count FROM users WHERE email = ?"
        result (jdbc/query db/database [query email])]
    (zero? (:count (first result)))))

(defn password-match? [password])

(defn hash-password [password])

(defn generate-hash [password] (hashers/derive password))

(defn insert-user [user]
  (jdbc/insert! db/database :users user))

