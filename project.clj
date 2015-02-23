(defproject clojure-react-renderer-proof-of-concept "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.5.0"

  ; need >= Java 8 in order to use Nashorn
  :javac-options     ["-target" "1.8" "-source" "1.8"]

  :ring {:handler clojure-react-renderer-proof-of-concept.core.handler/app
         :init    clojure-react-renderer-proof-of-concept.core.handler/init}

  :dependencies [
                   [org.clojure/clojure   "1.6.0"]
                   [compojure             "1.3.1"]
                   [org.clojure/data.json "0.2.5"]
                   [ring/ring-defaults    "0.1.3"]
                   [hiccup                "1.0.5"]
                   [environ               "1.0.0"]

                   ; TODO
                   ; firebase interface - https://github.com/verma/pani
                   [pani                  "0.0.3"]
                ]

  :plugins        [[lein-ring             "0.9.1"]
                   [lein-environ          "1.0.0"]]

  :profiles {:test-local {:dependencies [[midje "1.6.3"]
                                         [javax.servlet/servlet-api "2.5"]
                                         [ring-mock "0.1.5"]]

                           :plugins     [[lein-midje "3.1.3"]]}

             ;; Set these in ./profiles.clj
             :test-env-vars {}
             :dev-env-vars  {}

             :test [:test-local :test-env-vars]
             :dev  [:dev-env-vars]

             :production {:ring {:open-browser? false
                                 :stacktraces?  false
                                 :auto-reload?  false}}})
