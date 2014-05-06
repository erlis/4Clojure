(ns answers.core
  (:require [answers.elementary :as elementary]))


(defmacro show
  [f & args]
  (let [f-var# (resolve f)]
    `(println ~f-var# (~f ~@args))))


(defn -main
  []
  (show elementary/nothing-but-the-truth true)
  (show elementary/simple-math 4)
  (show elementary/intro-to-string "HELLO WORLD")
  (show elementary/intro-to-lists :a :b :c)
  (show elementary/lists-conj '(1 2 3 4) )
  (show elementary/intro-to-vectors :a :b :c)
  (show elementary/vectors-conj [1 2 3 4])
  (show elementary/intro-to-sets #{:a :b :c :d})
  (show elementary/sets-conj 2)
  (show elementary/intro-to-maps 20)
  (show elementary/maps-conj {:b 2})
  (show elementary/intro-to-seqs 3)
  (show elementary/sequences-rest [20 30 40])
  (show elementary/intro-to-functions 8)
)
