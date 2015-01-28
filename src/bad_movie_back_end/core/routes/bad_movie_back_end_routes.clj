(ns bad-movie-back-end.core.routes.bad-movie-back-end-routes

  (:import [
            javax.script
            ScriptEngineManager
            ])

  (:require
    [ring.util.response :as response]
    [compojure.core :refer :all]
    [bad-movie-back-end.core.views.bad-movie-back-end-layout :refer [common-layout]]))

(defn create-engine
  "Creates a new nashorn script engine and loads dependencies into its context."
  [scripts]
  (let [nashorn (.getEngineByName (ScriptEngineManager.) "nashorn")]
    (.eval nashorn "var global = this")
    (doseq [script scripts] (.eval nashorn (str "load('" script "');")))
    nashorn))

(def react "http://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.min.js")

(def firebase "https://cdn.firebase.com/js/client/2.0.4/firebase.js")

(def app "/Users/pdoherty/projects/bad-movie-poll-back-end/resources/public/javascripts/app.js")

(def nashorn (create-engine [react firebase app]))

; TODO
(defn post-route [request])

; TODO
(defn firebase-query [])

(def dummy-component "MyApp.create({name: 'Pete'})")

(defn react-render [component]
  (.eval nashorn (str "React.renderComponentToString(" component ")")))

(defn get-route [request]
  (common-layout (react-render dummy-component)))

(defroutes bad-movie-back-end-routes
           (GET  "/" [] get-route)
           (POST "/" [] post-route))


