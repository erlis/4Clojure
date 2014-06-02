(ns answers.medium
  (:use [clojure.test :only (is)]))

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
