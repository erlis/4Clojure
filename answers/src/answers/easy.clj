(ns answers.easy
  (:use [clojure.test :only (is)]))

(defn reverse-interleave
  "Write a function which reverses the interleave process into x number of subsequences."
  [__]
  (is (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (is (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (is (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

(defn reverse-interleave-answer
  [coll n]
  (->> (map (fn [[k v]] v )
            (group-by #(first %) (map-indexed #(vector (mod %1 n) %2) coll)))
       (map #(map second %) )
       ))


(defn factorial-fun
  "Write a function which calculates factorials."
  [__]
  (is (= (__ 1) 1))
  (is (= (__ 3) 6))
  (is (= (__ 5) 120))
  (is (= (__ 8) 40320)))

(defn factorial-fun-answer
  [x]
  (reduce * (range 1 (inc x) )))


(defn drop-every-nth-item
  "Write a function which drops every Nth item from a sequence."
  [__]
  (is (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (__ [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])))

(defn drop-every-nth-item-answer
  [coll p]
  (loop [xs coll
         sol []
         idx 1]
    (if (empty? xs)
      sol
      (if (= 0 (mod idx p))
        (recur (rest xs) sol (inc idx))
        (recur (rest xs) (conj sol (first xs)) (inc idx)))
      )
    ))


(defn interpose-a-seq
  "Write a function which separates the items of a sequence by an arbitrary value.
  SPECIAL RESTRICTION: interpose"
  [__]
  (is (= (__ 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

(defn interpose-a-seq-answer
  [sep coll]
  (butlast (flatten (for [x coll
                          y [sep]]
                      [x y]))))


(defn interleave-two-seqs
  "Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
  SPECIAL RESTRICTION: interleave"
  [__]
  (is (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (__ [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (__ [1 2 3 4] [5]) [1 5]))
  (is (= (__ [30 20] [25 15]) [30 25 20 15])))

(defn interleave-two-seqs-answer
  [xs1 xs2]
  (mapcat vector xs1 xs2))


(defn maximum-value
  "Write a function which takes a variable number of parameters and returns the maximum value.
  SPECIAL RESTRICTION: max, max-key"
  [__]
  (is (= (__ 1 8 3 4) 8))
  (is (= (__ 30 20) 30))
  (is (= (__ 45 67 11) 67)))

(defn maximum-value-answer
  [& coll]
  (reduce #(if (> %1 %2) %1 %2) coll))


(defn implement-range
  "Write a function which creates a list of all integers in a given range.
   SPECIAL RESTRICTION: range"
  [__]
  (is (= (__ 1 4) '(1 2 3)))
  (is (= (__ -2 2) '(-2 -1 0 1)))
  (is (= (__ 5 8) '(5 6 7))))

(defn implement-range-answer
  [x1 x2]
  (take (- x2 x1) (iterate inc x1) ))


(defn replicate-a-sequence
  "Write a function which replicates each element of a sequence a variable number of times."
  [__]
  (is (= (__ [1 2 3] 2) '(1 1 2 2 3 3)))
  (is (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
  (is (= (__ [4 5 6] 1) '(4 5 6)))
  (is (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (__ [44 33] 2) [44 44 33 33])))

(defn replicate-a-sequence-answer
  [coll n]
  (mapcat #(repeat n %) coll))


(defn duplicate-a-sequence
  "Write a function which duplicates each element of a sequence."
  [__]
  (is (= (__ [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

(defn duplicate-a-sequence-answer
  [coll]
  (mapcat #(vector % %) coll))


(defn pack-a-sequence
  "Write a function which packs consecutive duplicates into sub-lists."
  [__]
  (is (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
  (is (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
  (is (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

(defn pack-a-sequence-answer
  [coll]
  (partition-by identity coll))


(defn compress-a-sequence
  "Write a function which removes consecutive duplicates from a sequence."
  [__]
  (is (= (apply str (__ "Leeeeeerrroyyy")) "Leroy"))
  (is (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))
)

(defn compress-a-sequence-answer
  [coll]
  (map first (partition-by identity coll))) 


(defn get-the-caps
  "Write a function which takes a string and returns a new string containing only the capital letters."
  [__]
  (is (= (__ "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (__ "nothing")))
  (is (= (__ "$#A(*&987Zf") "AZ")))

(defn get-the-caps-answer
  [x]
  (apply str (filter #(let [i (int %)] (and (>= i 65) (<= i 90) )) x))) 


(defn flatten-a-sequence
  "Write a function which flattens a sequence"
  [__]
  (is (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (__ ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (__ '((((:a))))) '(:a))))

(defn flatten-a-sequence-answer
  [coll]
  (mapcat #(if (coll? %)
             (flatten-a-sequence-answer %)
             [%]) coll))


(defn palindrome-detector
  "Write a function which returns true if the given sequence is a palindrome.
   Hint: 'racecar' does not equal '\\r \\a \\c \\e \\c \\a \\r)"
  [__]
  (is (false? (__ '(1 2 3 4 5))))
  (is (true? (__ "racecar")))
  (is (true? (__ [:foo :bar :foo])))
  (is (true? (__ '(1 1 3 3 1 1))))
  (is (false? (__ '(:a :b :c)))))

(defn palindrome-detector-answer
  [xs]
  (= (seq xs) (reverse xs)))


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
