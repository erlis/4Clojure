(ns answers.elementary
  (:use [clojure.test :only (is)]))


(defn recurring-theme
  "Clojure only has one non-stack-consuming looping construct: recur. Either a function or a loop can be used as the recursion point. Either way, recur rebinds the bindings of the recursion point to the values it is passed. Recur must be called from the tail-position, and calling it elsewhere will result in an error."
  [__]
  (is (= __
         (loop [x 5
                result []]
           (if (> x 0)
             (recur (dec x) (conj result (+ 2 x)))
             result)))))


(defn rearranging-code->
  "The -> macro threads an expression x through a variable number of forms. First, x is inserted as the second item in the first form, making a list of it if it is not a list already. Then the first form is inserted as the second item in the second form, making a list of that form if necessary. This process continues for all the forms. Using -> can sometimes make your code more readable."
  [__]
  (is (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
         (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
         5)))


(defn simple-recursion
  "A recursive function is a function which calls itself. This is one of the fundamental techniques used in functional programming."
  [__]
  (is (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))


(defn intro-to-reduce
  "Reduce takes a 2 argument function and an optional starting value. It then applies the function to the first 2 items in the sequence (or the starting value and the first element of the sequence). In the next iteration the function will be called on the previous return value and the next item from the sequence, thus reducing the entire collection to one value. Don't worry, it's not as complicated as it sounds."
  [__]
  (is (= 15 (reduce __ [1 2 3 4 5])))
  (is (=  0 (reduce __ [])))
  (is (=  6 (reduce __ 1 [2 3]))))


(defn regular-expressions
  "Regex patterns are supported with a special reader macro."
  [__]
  (is (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))


(defmacro let-it-be
  "Can you bind x, y, and z so that these are all true?"
  [__]
  `(is (= 10 (let ~__ (+ ~'x ~'y))))
  `(is (=  4 (let ~__ (+ ~'y ~'z))))
  `(is (=  1 (let ~__ ~'z))))


(defn local-bindings
  "Clojure lets you give local names to values using the special let-form."
  [__]
  (is (= __ (let [x 5] (+ 2 x))))
  (is (= __ (let [x 3, y 10] (- y x))))
  (is (= __ (let [x 21] (let [y 3] (/ x y))))))


(defn sequences-filter
  "The filter function takes two arguments: a predicate function (f) and a sequence (s). Filter returns a new sequence consisting of all the items of s for which (f item) returns true."
  [__]
  (is (= __ (filter #(> % 5) '(3 4 5 6 7)))))


(defn sequences-map
  "The map function takes two arguments: a function (f) and a sequence (s). Map returns a new sequence consisting of the result of applying f to each item of s. Do not confuse the map function with the map data structure."
  [__]
  (is (= __ (map #(+ % 5) '(1 2 3)))))


(defn hello-world
  "Write a function which returns a personalized greeting."
  [__]
  (is (= (__ "Dave") "Hello, Dave!"))
  (is (= (__ "Jenn") "Hello, Jenn!"))
  (is (= (__ "Rhea") "Hello, Rhea!")))


(defn double-down
  "Write a function which doubles a number."
  [__]
  (is (= (__ 2) 4))
  (is (= (__ 3) 6))
  (is (= (__ 11) 22))
  (is (= (__ 7) 14)))


(defn intro-to-functions
  "Clojure has many different ways to create functions."
  [__]
  (is (= __ ((fn add-five [x] (+ x 5)) 3)))
  (is (= __ ((fn [x] (+ x 5)) 3)))
  (is (= __ (#(+ % 5) 3)))
  (is (= __ ((partial + 5) 3))))


(defn sequences-rest
  "The rest function will return all the items of a sequence except the first."
  [__]
  (is (= __ (rest [10 20 30 40]))))


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


