(ns nucleotide-count
  (:require [clojure.string :as string]))




(defn count [base secuencia]
  (assert (re-find #"[CGTA]" (str base)))
  (if (string/blank? secuencia)
    0
    (get (frequencies secuencia)
         base)))





(defn nucleotide-counts [secuencia]
  (merge {\A 0
          \T 0
          \C 0
          \G 0}
         (frequencies secuencia)))






