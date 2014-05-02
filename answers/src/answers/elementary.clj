(ns answers.elementary
  (:use [clojure.test]))

(defn intro-to-lists [& __]
  (is (= (apply list __) '(:a :b :c))))


(defn intro-to-string [__]
  (is (= __ (.toUpperCase "hello world"))))


(defn simple-math [__]
  (is (= (- 10 (* 2 3)) __)))


(defn nothing-but-the-truth [__]
  (is (= __ true)))


