(ns answers.medium
  (:require [clojure.string]
            [clojure.test :refer [is]]))

(defn merge-with-a-function
  "Write a function which takes a function f and a variable number of maps. Your function should return a map that consists of the rest of the maps conj-ed onto the first. If a key occurs in more than one map, the mapping(s) from the latter (left-to-right) should be combined with the mapping in the result by calling (f val-in-result val-in-latter)
   SPECIAL RESTRICTIONS: merge-with"
  [__]
  (is (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
         {:a 4, :b 6, :c 20}))
  (is (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
         {1 7, 2 10, 3 15}))
  (is (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
         {:a [3 4 5], :b [6 7], :c [8 9]}))
  )

(defn merge-with-a-function-answer
  [f & colls]
  )


(defn prime-numbers
  "Write a function which returns the first x number of prime numbers"
  [__]
  (is (= (__ 2) [2 3]))
  (is (= (__ 5) [2 3 5 7 11]))
  (is (= (last (__ 100)) 541)))

(defn prime-numbers-answer 
  [n]
  (loop [x 3
         acc [2]]
    (if (= n (count acc))
      acc
      (if (some zero? (map #(mod x %) acc))
        (recur (inc x) acc)
        (recur (inc x) (conj acc x))))))


(defn black-box-testing
  " Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform 'sequence' type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.

  Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.
  You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
  SPECIAL RESTRICTIONS: class
                        type
                        Class
                        vector?
                        sequential?
                        list?
                        seq?
                        map?
                        set?
                        instance?
                        getClass"
  [__]
  (is (= :map (__ {:a 1, :b 2})))
  (is (= :list (__ (range (rand-int 20)))))
  (is (= :vector (__ [1 2 3 4 5 6])))
  (is (= :set (__ #{10 (rand-int 5)})))
  (is (= [:map :set :vector :list] (map __ [{} #{} [] ()]))))

(defn black-box-testing-answer
  [coll]
  (let [xs (conj coll [:www :zzz] [:xxx :yyy])]
    (cond
     (= :yyy (get xs :xxx)) :map
     (= [:xxx :yyy] (get xs [:xxx :yyy])) :set
     (= [:xxx :yyy] (first xs)) :list
     :else :vector
     )))


(defn sequence-reductions
  "Write a function which behaves like reduce, but returns each intermediate value of the reduction. Your function must accept either two or three arguments, and the return sequence must be lazy.
  SPECIAL RESTRICTIONS: reductions"
  [__]
  (is (= (take 5 (__ + (range))) [0 1 3 6 10]))
  (is (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
  (is (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))

(defn sequence-reductions-answer
  ([f coll] (sequence-reductions-answer f (first coll) (rest coll) ))
  ([f val coll]
     (if (empty? coll)
       [val]
       (cons val (lazy-seq (sequence-reductions-answer f (f val (first coll)) (rest coll)))))))


(defn juxtaposition
  "Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.
  SPECIAL RESTRICTION: juxt"
  [__]
  (is (= [21 6 1] ((__ + max min) 2 3 5 1 6 4)))
  (is (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello")))
  (is (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))

(defn juxtaposition-answer
  [& fargs]
  (fn [& args]
    (map #(apply % args) fargs)))


(defn function-composition
  "Write a function which allows you to create function compositions. The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
  SPECIAL RESTRICTION: comp"
  [__]
  (is (= [3 2 1] ((__ rest reverse) [1 2 3 4])))
  (is (= 5 ((__ (partial + 3) second) [1 2 3 4])))
  (is (= true ((__ zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

(defn function-composition-answer
  [& fs]
  ((fn my-comp [xs]
     (if (= 1 (count xs))
       (first xs)
       (fn [& args] ((first xs) (apply (my-comp (rest xs)) args))) ))
   fs))


(defn find-distinct-items
  "Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
  SPECIAL RESTRICTION: distinct"
  [__]
  (is (= (__ [1 2 1 3 1 2 4]) [1 2 3 4]))
  (is (= (__ [:a :a :b :b :c :c]) [:a :b :c]))
  (is (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
  (is (= (__ (range 50)) (range 50))))

(defn find-distinct-items-answer
  [coll]
  (reduce (fn [sol x]
            (if (some #{x} sol)
              sol
              (concat sol [x])) ) (empty coll) coll))


(defn count-occurrences
  "Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
  SPECIAL RESTRICTION: frequencies"
  [__]
  (is (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (__ [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(defn count-occurrences-answer
  [coll]
  (apply hash-map (mapcat (fn [[key xs]] [key (count xs)]) (group-by identity coll))))


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
