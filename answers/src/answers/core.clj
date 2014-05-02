(ns answers.core
  (:require [answers.elementary :as elementary]))


(defmacro show
  [f & args]
  (let [f-var# (resolve f)]
    `(println ~f-var# (~f ~@args))))


(defn -main
  []
  (show elementary/nothing-but-the-truth true))
