(ns clojure-http.routes.books
  (:require [clojure-http.db.books :as books]
            [clojure.data.json :as json]))

(defn books-handler [req] {:status 200
                           :headers {"Content-type" "text/json"}
                           :body (json/write-str {:response (books/get-books)})})

(defn add-books-handler [req] {:status 201
                               :headers {"Content-type" "text/json"}
                               :body (json/write-str {:response (books/get-books)})})
