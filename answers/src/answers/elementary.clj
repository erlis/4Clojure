(ns answers.elementary
  (:use [clojure.test :only (is)]))


(defn intro-to-seqs
  "All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last."
  [__]
  (is (= __ (first '(3 2 1))))
  (is (= __ (second [2 3 4])))
  (is (= __ (last (list 1 2 3)))))


(defn maps-conj
  "When operating on a map, the conj function returns a new map with one or more key-value pairs 'added'"
  [__]
  (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3])))


(defn intro-to-maps
  "Maps store key-value pairs. Both maps and keywords can be used as lookup functions. Commas can be used to make maps more readable, but they are not required."
  [__]
  (is (= __ ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= __ (:b {:a 10, :b 20, :c 30}))))


(defn sets-conj
  "When operating on a set, the conj function returns a new set with one or more keys 'added'."
  [__]
  (is (= #{1 2 3 4} (conj #{1 4 3} __))))


(defn intro-to-sets
  "Sets are collections of unique values."
  [__]
  (is (= __ (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))))

(defn vectors-conj
  "When operating on a Vector, the conj function will return a new vector with one or more items 'added' to the end."
  [__]
  (is (= __ (conj [1 2 3] 4)))
  (is (= __ (conj [1 2] 3 4))))


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


