(ns answers.easy
  (:use [clojure.test :only (is)]))


(defn nth-element
  "Write a function which returns the Nth element from a sequence.
  ::Special Restriction:: nth"
  [__]
  (is (= (__ '(4 5 6 7) 2) 6))
  (is (= (__ [:a :b :c] 0) :a))
  (is (= (__ [1 2 3 4] 1) 2))
  (is (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])))

(defn nth-element-answer
  [col index]
  ((apply vector col) index))


(defn penultimate-element
  "Write a function which returns the second to last element from a sequence."
  [__]
  (is (= (__ (list 1 2 3 4 5)) 4))
  (is (= (__ ["a" "b" "c"]) "b"))
  (is (= (__ [[1 2] [3 4]]) [1 2])))


(defn last-element
  "Write a function which returns the last element in a sequence.
   ::Special Restriction:: last "
  [__]
  (is (= (__ [1 2 3 4 5]) 5))
  (is (= (__ '(5 4 3)) 3))
  (is (= (__ ["b" "c" "d"]) "d")))
