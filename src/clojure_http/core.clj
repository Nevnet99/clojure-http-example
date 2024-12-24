(ns clojure-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :as cj]
            [compojure.route :as route]
            [clojure-http.routes.books :as books]
            [clojure-http.routes.authentication :as authentication])
  (:gen-class))



(cj/defroutes app-routes
  (cj/GET "/books" [] books/books-handler)
  (cj/POST "/books" req (books/add-books-handler req))
  (cj/POST "/authentication/login" req (authentication/login-handler req))
  (cj/POST "/authentication/logout" req (authentication/logout-handler req))
  (cj/POST "/authentication/register" req (authentication/register-handler req))
  (route/not-found "Route not supported"))


(defn -main [& args]
  (run-server app-routes {:port 8080})
  (println "Server started on port 8080"))

