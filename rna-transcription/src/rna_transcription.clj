(ns rna-transcription
  (:require [clojure.string :as string]))

(defn letter [letra]
  (case letra
    "C" "G"
    "G" "C"
    "T" "A"
    "A" "U"))

(defn to-rna [cont]
  (assert (re-find #"^[CGTA]+$" cont))
  (string/replace cont #"[CGTA]" letter))


