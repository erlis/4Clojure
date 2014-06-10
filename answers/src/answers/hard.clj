(ns answers.hard
  (:use [clojure.test :only (is)]))

(defn analyze-a-tic-tac-toe-board
  "A tic-tac-toe board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e. A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row. Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won."
  [__]
  (is (= nil (__ [[:e :e :e]
            [:e :e :e]
            [:e :e :e]])))
  (is (= :x (__ [[:x :e :o]
           [:x :e :e]
           [:x :e :o]])))
  (is (= :o (__ [[:e :x :e]
           [:o :o :o]
           [:x :e :x]])))
  (is (= nil (__ [[:x :e :o]
            [:x :x :e]
            [:o :x :o]])))
  (is (= :x (__ [[:x :e :e]
           [:o :x :e]
           [:o :e :x]])))
  (is (= :o (__ [[:x :e :o]
           [:x :o :e]
           [:o :e :x]])))
  (is (= nil (__ [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))))

(defn analyze-a-tic-tac-toe-board-answer
  [tab]
  (let [hor (into #{} tab)
        ver (into hor (apply map vector tab))
        d1  (conj ver (into [] (map #(%1 %2) [first second last] tab)))
        d2  (conj d1  (into [] (map #(%1 %2) [last second first] tab)))
        all d2]
    (cond
     (all [:x :x :x]) :x
     (all [:o :o :o]) :o
     :else nil)
    ))

(defn longest-increasing-sub-seq
  "Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify."
  [__]
  (is (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (__ [5 6 1 3 2 7]) [5 6]))
  (is (= (__ [2 3 3 4 5]) [3 4 5]))
  (is (= (__ [7 6 5 4]) [])))

(defn longest-increasing-sub-seq-answer
  [coll]
  (->>(map - (rest coll) coll)
      (map-indexed #(vector %1 %2))
      (partition-by #(= 1 (second %)) )
      (filter #(= 1  (second (first %))) )
      ((fn [xs] (if (empty? xs) xs (reduce #(if (> (count %1) (count %2)) %1 %2) xs))))
      ((fn [xs] (if (empty? xs) xs (take (inc (count xs)) (drop (first (first xs)) coll)))))
      )
  )
