(ns octal)

(def to-digit { \0 0, \1 1, \2 2, \3 3, \4 4, \5 5, \6 6, \7 7})

(defn to-decimal [number]
  (if (every? identity (map to-digit number))
    (reduce + (map-indexed #(* %2 (biginteger (Math/pow 8 %1)))
                           (reverse (map to-digit number))))
    0))
