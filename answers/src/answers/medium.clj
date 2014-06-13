(ns answers.medium
  (:require [clojure.string])
  (:use [clojure.test :only (is)]))

(defn filter-perfect-squares
  "Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares."
  [__]
  (is (= (__ "4,5,6,7,8,9") "4,9"))
  (is (= (__ "15,16,25,36,37") "16,25,36")))


(defn filter-perfect-squares-answer
  [s]
  (let [nseq (->>(clojure.string/split s #",")
                 (map #(Integer/parseInt %) ))
        lzsquares (map (fn [x] (* x x)) (iterate inc 1))
        maxinseq (apply max nseq) ]
    (->> (map #(some #{%} (take-while (partial >= maxinseq) lzsquares)) nseq)
         (keep identity)
         (clojure.string/join ",")
         )))

(defn partition-a-sequence
  "Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.
  RESTRICTION: partition, partition-all"
  [__]
  (is (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))))

(defn partition-a-sequence-answer
  [n coll]
  (loop [sol []
         xs coll]
    (if (empty? xs)
      sol
      (recur (if (>= (count xs) n) (conj sol (take n xs)) sol)
             (drop n xs)))))


(defn split-by-type
  "Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases)."
  [__]
  (is (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
  (is (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
  (is (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))

(defn split-by-type-answer
  [coll]
  (->> (group-by type coll)
       vec
       (map second)))


(defn flipping-out
  "Write a higher-order function which flips the order of the arguments of an input function."
  [__]
  (is (= 3 ((__ nth) 2 [1 2 3 4 5])))
  (is (= true ((__ >) 7 8)))
  (is (= 4 ((__ quot) 2 8)))
  (is (= [1 2 3] ((__ take) [1 2 3 4 5] 3))))

(defn flipping-out-answer
  [f]
  (fn [x1 x2]
    (f x2 x1)))


(defn rotate-sequence
  "Write a function which can rotate a sequence in either direction."
  [__]
  (is (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (is (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (is (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (is (= (__ 1 '(:a :b :c)) '(:b :c :a)))
  (is (= (__ -4 '(:a :b :c)) '(:c :a :b))))

(defn rotate-sequence-answer
  [d coll]
  (let [f (if (neg? d)
            reverse
            identity)
        pd (max d (- d) )]
    (->> (cycle (f coll))
         (drop pd)
         (take (count coll))
         f)))
