(ns answers.core
  (:require [answers.elementary :as elementary]
            [answers.easy :as easy]))


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
  (show elementary/double-down #(* 2 %) )
  (show elementary/hello-world #(str "Hello, " % "!" ) )
  (show elementary/sequences-map '(6 7 8))
  (show elementary/sequences-filter '(6 7))
  (show elementary/local-bindings 7)
  (show elementary/let-it-be [z 1, y 3, x 7])
  (show elementary/regular-expressions "ABC")
  (show elementary/intro-to-reduce +)
  (show elementary/simple-recursion '(5 4 3 2 1))
  (show elementary/rearranging-code-> last)
  (show elementary/recurring-theme [7 6 5 4 3])
  (show easy/last-element #(-> % reverse first))
  (show easy/penultimate-element (comp second reverse))
  (show easy/nth-element easy/nth-element-answer)
  (show easy/count-a-sequence easy/count-a-sequence-answer)
  (show easy/reverse-a-sequence easy/reverse-a-sequence-answer)
  (show easy/sum-it-all-up easy/sum-it-all-up-answer)
  (show easy/find-the-odd-numbers easy/find-the-odd-numbers-answer)
  (show easy/fibonacci-seqs easy/fibonacci-seqs-answer)
  (show easy/palindrome-detector easy/palindrome-detector-answer)
  (show easy/flatten-a-sequence easy/flatten-a-sequence-answer)
  (show easy/get-the-caps easy/get-the-caps-answer)
)
