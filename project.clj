(defproject clojure-http "0.1.0-SNAPSHOT"
  :description "An example of a HTTP server with clojure"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure   "1.11.1"]
                 [http-kit/http-kit      "2.8.0"]
                 [compojure              "1.7.1"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.6.0"]
                 [org.clojure/data.json "2.5.1"]
                 [buddy/buddy-hashers "2.0.167"]]
  :main ^:skip-aot clojure-http.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
