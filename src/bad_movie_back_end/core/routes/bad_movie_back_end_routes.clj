(ns bad-movie-back-end.core.routes.bad-movie-back-end-routes

  (:import [
            javax.script
            ScriptEngineManager
            ])

  (:require
    [ring.util.response :as response]
    [compojure.core :refer :all]
    [bad-movie-back-end.core.views.bad-movie-back-end-layout :refer [common-layout]]))

(def nashorn (.getEngineByName (ScriptEngineManager.) "nashorn"))

;TODO: feed in react, firebase and BMP libraries
; (defn create-engine
;   "Creates a new nashorn script engine and loads a bunch of scripts into it."
;   [scripts]
;   (let [nashorn (.getEngineByName (ScriptEngineManager.) "nashorn")]
;     ;; Browser module shims expects either 'window' or 'global' to be around.
;     (.eval nashorn "var global = this")
;     ;; 'scripts' is a list of strings or readables, load them all into nashorn.
;     (doseq [script scripts] (.eval nashorn script))
;     nashorn))

(defn fetch-url[address]
  (with-open [stream (.openStream (java.net.URL. address))]
    (let  [buf (java.io.BufferedReader. (java.io.InputStreamReader. stream))]
      (apply str (line-seq buf)))))

(def react
  (fetch-url "http://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.min.js"))

(def firebase
  (fetch-url "https://cdn.firebase.com/js/client/2.0.4/firebase.js"))

; TODO
(defn post-route [request])

(defn react-render [component]
  (.eval nashorn "var global = this")
  (.eval nashorn react)
  (.eval nashorn (str "React.renderComponentToString(" component ")")))

; TODO
(defn firebase-query [])

(def dummy-component
  "React.createClass({render: function () {return React.DOM.h1(null, 'HELLO FROM NASHORN')}})()")

(defn get-route [request]
  (common-layout (react-render dummy-component)))

(defroutes bad-movie-back-end-routes
           (GET  "/" [] get-route)
           (POST "/" [] post-route))


