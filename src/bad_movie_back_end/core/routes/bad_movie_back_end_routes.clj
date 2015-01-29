(ns bad-movie-back-end.core.routes.bad-movie-back-end-routes

  (:import [
            javax.script
            ScriptEngineManager])

  (:require
    [clojure.data.json :as json]
    [ring.util.response :as response]
    [compojure.core :refer :all]
    [bad-movie-back-end.core.views.bad-movie-back-end-layout :refer [common-layout]]))

(defn create-engine
  "Creates a new nashorn script engine and loads dependencies into its context."
  [dependencies]
  (let [nashorn (.getEngineByName (ScriptEngineManager.) "nashorn")
        scripts (map #(str "load('" % "');") dependencies)]
    (.eval nashorn "var global = this;")
    (doseq [script scripts] (.eval nashorn script))
    nashorn))

(def react "http://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.min.js")

(defn local-script [path]
  (clojure.java.io/resource (str "public/javascripts/" path)))

(def app (local-script "app.js"))

(def nashorn (create-engine [react app]))

(def dummy-data {:name "Pete"})

(defn dummy-component [data]
  (str "MyApp.create(" (json/write-str data) ")"))

(defn react-render [component]
  (.eval nashorn (str "React.renderComponentToString(" component ")")))

(defn get-route [request]
  (common-layout (react-render (dummy-component dummy-data))))

(defroutes bad-movie-back-end-routes
           (GET  "/" [] get-route))


