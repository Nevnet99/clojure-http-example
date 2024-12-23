(ns clojure-http.db.books
  (:require [clojure.java.jdbc :as jdbc]
            [clojure-http.db.core :as db]))

(defn get-books []
  (jdbc/query db/database ["SELECT * from books"]))



