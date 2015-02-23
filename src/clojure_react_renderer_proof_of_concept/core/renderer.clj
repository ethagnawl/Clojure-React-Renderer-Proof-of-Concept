(ns clojure-react-renderer-proof-of-concept.core.renderer

  (:import [
            javax.script
            ScriptEngineManager])

  (:require
    [clojure.data.json :as json]
    [clojure-react-renderer-proof-of-concept.core.views.clojure-react-renderer-proof-of-concept-layout :refer [common-layout]]))

(defn- local-script [path]
  (clojure.java.io/resource (str "public/javascripts/" path)))

(defn- create-engine
  "Creates a new nashorn script engine and loads dependencies into its context."
  [dependencies]
  (let [nashorn (.getEngineByName (ScriptEngineManager.) "nashorn")
        scripts (map #(str "load('" % "');") dependencies)]
    (.eval nashorn "var global = this;")
    (doseq [script scripts] (.eval nashorn script))
    nashorn))

(def ^:private react "http://cdnjs.cloudflare.com/ajax/libs/react/0.12.2/react.min.js")

(def ^:private app (local-script "app.js"))

(def ^:private nashorn (create-engine [react app]))

(def ^:private dummy-data {:name "Pete"})

(defn- react-render [component]
  (.eval nashorn (str "React.renderComponentToString(" component ")")))

(defn- dummy-component [data]
  (str "MyApp.create(" (json/write-str data) ")"))

(defn render [_] (react-render (dummy-component dummy-data)))
