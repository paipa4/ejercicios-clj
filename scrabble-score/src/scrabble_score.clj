(ns scrabble-score
   (:require [clojure.string :as str]))

(def points {\d 2, \g 2
             \b 3, \c 3, \m 3, \p 3
             \f 4, \h 4, \v 4, \w 4, \y 4
             \k 5
             \j 8, \x 8
             \q 10, \z 10})

(defn score-letter [letter]
  (if (string? letter)
     (score-letter (first (str/lower-case letter)))
     (get points letter 1)))

(defn score-word [word]
    (reduce + (map score-letter (str/lower-case word))))

