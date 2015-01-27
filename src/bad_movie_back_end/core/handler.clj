(ns bad-movie-back-end.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [bad-movie-back-end.core.routes.bad-movie-back-end-routes :refer [bad-movie-back-end-routes]]
            ))

(defroutes app-routes
  (route/not-found "Not Found"))

(def app
  (-> (routes bad-movie-back-end-routes app-routes)
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))
