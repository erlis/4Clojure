(ns answers.easy
  (:use [clojure.test :only (is)]))

(defn fibonacci-seqs
  "Write a function which returns the first X fibonacci numbers."
  [__]
  (is (= (__ 3) '(1 1 2)))
  (is (= (__ 6) '(1 1 2 3 5 8)))
  (is (= (__ 8) '(1 1 2 3 5 8 13 21))))

(defn fibonacci-seqs-answer
  [x]
  (take x (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))


(defn find-the-odd-numbers
  "Write a function which returns only the odd numbers from a sequence."
  [__]
  (is (= (__ #{1 2 3 4 5}) '(1 3 5)))
  (is (= (__ [4 2 1 6]) '(1)))
  (is (= (__ [2 2 4 6]) '()))
  (is (= (__ [1 1 1 3]) '(1 1 1 3))))

(defn find-the-odd-numbers-answer
  [xs]
  (filter odd? xs))


(defn sum-it-all-up
  "Write a function which returns the sum of a sequence of numbers."
  [__]
  (is (= (__ [1 2 3]) 6))
  (is (= (__ (list 0 -2 5 5)) 8))
  (is (= (__ #{4 2 1}) 7))
  (is (= (__ '(0 0 -1)) -1))
  (is (= (__ '(1 10 3)) 14)))

(defn sum-it-all-up-answer
  [xs]
  (#(reduce + %) xs))



(defn reverse-a-sequence
  "Write a function which reverses a sequence.
   ::Special Restriction:: reverse"
  [__]
  (is (= (__ [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (__ (sorted-set 5 7 2 7)) '(7 5 2)))
  (is (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])))

(defn reverse-a-sequence-answer
  [xs]
  (if (empty? xs)
    xs
    (let [f (first xs)
          r (rest xs)]
      (concat (reverse-a-sequence-answer r) (vector f)))))


(defn count-a-sequence
  "Write a function which returns the total number of elements in a sequence.
   ::Special Restriction:: count"
  [__]
  (is (= (__ '(1 2 3 3 1)) 5))
  (is (= (__ "Hello World") 11))
  (is (= (__ [[1 2] [3 4] [5 6]]) 3))
  (is (= (__ '(13)) 1))
  (is (= (__ '(:a :b :c)) 3)))

(defn count-a-sequence-answer
  [xs]
  (loop [col xs,
         res 0]
    (if (empty? col)
      res
      (recur (rest col) (inc res))))
)


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
