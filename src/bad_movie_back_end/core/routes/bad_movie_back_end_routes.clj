(ns bad-movie-back-end.core.routes.bad-movie-back-end-routes

  (:import [
            javax.script
            ScriptEngineManager
            ])

  (:require
    [ring.util.response :as response]
    [compojure.core :refer :all]
    [bad-movie-back-end.core.views.bad-movie-back-end-layout :refer [
                                                         common-layout
                                                         read-contact
                                                         ]]))

(def nashorn (.getEngineByName (ScriptEngineManager.) "nashorn"))

(defn fetch-url[address]
  (with-open [stream (.openStream (java.net.URL. address))]
    (let  [buf (java.io.BufferedReader. (java.io.InputStreamReader. stream))]
      (apply str (line-seq buf)))))

(def react
  (fetch-url "http://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.min.js"))

(defn post-route [request]
    (response/redirect "/"))

(defn react-render [component]
  (.eval nashorn "var global = this")
  (.eval nashorn react)
  (.eval nashorn (str "React.renderComponentToString(" component ")")))

(def dummy-component
  "React.createClass({render: function () {return React.DOM.h1(null, 'HELLO FROM NASHORN')}})()")

(defn get-route [request]
  (react-render dummy-component))

(defroutes bad-movie-back-end-routes
           (GET  "/" [] get-route)
           (POST "/" [] post-route))


