(ns answers.elementary
  (:use [clojure.test :only (is)]))


(defn intro-to-vectors
  "Vectors can be constructed several ways. You can compare them with lists."
  [& __]
  (is (= (apply vector __) (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))) )


(defn lists-conj
  "When operating on a list, the conj function will return a new list with one or more items  'added' to the front."
  [__]
  (is (= __ (conj '(2 3 4) 1)))
  (is (= __ (conj '(3 4) 2 1))))


(defn intro-to-lists
  "Lists can be constructed with either a function or a quoted form."
  [& __]
  (is (= (apply list __) '(:a :b :c))))


(defn intro-to-string
  "Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings."
  [__]
  (is (= __ (.toUpperCase "hello world"))))


(defn simple-math [__]
  (is (= (- 10 (* 2 3)) __)))


(defn nothing-but-the-truth [__]
  (is (= __ true)))


