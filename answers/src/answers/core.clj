(ns answers.core
  (:require [answers.elementary :as elementary]
            [answers.easy :as easy]
            [answers.medium :as medium]
            [answers.hard :as hard]))


(defmacro show
  [f & args]
  (let [f-var# (resolve f)]
    `(println ~f-var# (~f ~@args))))


(defn -main
  []
  (show elementary/nothing-but-the-truth true)
  (show elementary/simple-math 4)
  (show elementary/intro-to-string "HELLO WORLD")
  (show elementary/intro-to-lists :a :b :c)
  (show elementary/lists-conj '(1 2 3 4) )
  (show elementary/intro-to-vectors :a :b :c)
  (show elementary/vectors-conj [1 2 3 4])
  (show elementary/intro-to-sets #{:a :b :c :d})
  (show elementary/sets-conj 2)
  (show elementary/intro-to-maps 20)
  (show elementary/maps-conj {:b 2})
  (show elementary/intro-to-seqs 3)
  (show elementary/sequences-rest [20 30 40])
  (show elementary/intro-to-functions 8)
  (show elementary/double-down #(* 2 %) )
  (show elementary/hello-world #(str "Hello, " % "!" ) )
  (show elementary/sequences-map '(6 7 8))
  (show elementary/sequences-filter '(6 7))
  (show elementary/local-bindings 7)
  (show elementary/let-it-be [z 1, y 3, x 7])
  (show elementary/regular-expressions "ABC")
  (show elementary/intro-to-reduce +)
  (show elementary/simple-recursion '(5 4 3 2 1))
  (show elementary/rearranging-code-> last)
  (show elementary/recurring-theme [7 6 5 4 3])
  (show easy/last-element #(-> % reverse first))
  (show easy/penultimate-element (comp second reverse))
  (show easy/nth-element easy/nth-element-answer)
  (show easy/count-a-sequence easy/count-a-sequence-answer)
  (show easy/reverse-a-sequence easy/reverse-a-sequence-answer)
  (show easy/sum-it-all-up easy/sum-it-all-up-answer)
  (show easy/find-the-odd-numbers easy/find-the-odd-numbers-answer)
  (show easy/fibonacci-seqs easy/fibonacci-seqs-answer)
  (show easy/palindrome-detector easy/palindrome-detector-answer)
  (show easy/flatten-a-sequence easy/flatten-a-sequence-answer)
  (show easy/get-the-caps easy/get-the-caps-answer)
  (show easy/compress-a-sequence easy/compress-a-sequence-answer)
  (show easy/pack-a-sequence easy/pack-a-sequence-answer)
  (show easy/duplicate-a-sequence easy/duplicate-a-sequence-answer)
  (show easy/replicate-a-sequence easy/replicate-a-sequence-answer)
  (show easy/implement-range easy/implement-range-answer)
  (show easy/maximum-value easy/maximum-value-answer)
  (show easy/interleave-two-seqs easy/interleave-two-seqs-answer)
  (show easy/interpose-a-seq easy/interpose-a-seq-answer)
  (show easy/drop-every-nth-item easy/drop-every-nth-item-answer)
  (show easy/factorial-fun easy/factorial-fun-answer)
  (show easy/reverse-interleave easy/reverse-interleave-answer)
  (show medium/rotate-sequence medium/rotate-sequence-answer)
  (show easy/intro-to-iterate '(1 4 7 10 13))
  (show medium/flipping-out medium/flipping-out-answer)
  (show easy/contain-yourself 4)
  (show easy/intro-to-some 6)
  (show easy/split-a-sequence easy/split-a-sequence-answer)
  (show medium/split-by-type medium/split-by-type-answer)
  (show easy/advanced-destructuring [1 2 3 4 5])
  (show easy/intro-to-destructuring)
  (show hard/longest-increasing-sub-seq hard/longest-increasing-sub-seq-answer)
  (show medium/partition-a-sequence medium/partition-a-sequence-answer)
  (show elementary/rearranging-code->> #(reduce + %))
  (show hard/analyze-a-tic-tac-toe-board hard/analyze-a-tic-tac-toe-board-answer)
  (show medium/filter-perfect-squares medium/filter-perfect-squares-answer)
  (show medium/count-occurrences medium/count-occurrences-answer)
  (show medium/find-distinct-items medium/find-distinct-items-answer)
  (show medium/function-composition medium/function-composition-answer)
  (show medium/juxtaposition medium/juxtaposition-answer)
  (show medium/sequence-reductions medium/sequence-reductions-answer)
  (show easy/map-construction easy/map-construction-answer)
  (show easy/reimplement-iterate easy/reimplement-iterate-answer)
  (show easy/group-a-sequence easy/group-a-sequence-answer)
  (show medium/black-box-testing medium/black-box-testing-answer)
  (show easy/greatest-common-divisor easy/greatest-common-divisor-answer)
  (show medium/prime-numbers medium/prime-numbers-answer)
  (show medium/merge-with-a-function medium/merge-with-a-function-answer)
)
