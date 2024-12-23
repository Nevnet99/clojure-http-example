(ns clojure-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :as cj]
            [compojure.route :as route]
            [clojure-http.routes.books :as books]
            [clojure-http.routes.authentication :as authentication])
  (:gen-class))



(cj/defroutes app-routes
  (cj/GET "/books" [] books/books-handler)
  (cj/POST "/books" [] books/add-books-handler)
  (cj/POST "/authentication/login" [] authentication/login-handler)
  (cj/POST "/authentication/logout" [] authentication/logout-handler)
  (cj/POST "/authentication/register" [ctx] (authentication/register-handler ctx))
  (route/not-found "Route not supported"))


(defn -main [& args]
  (run-server app-routes {:port 8080})
  (println "Server started on port 8080"))

