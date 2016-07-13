(ns allergies)

(def all
         {1 :eggs
          2 :peanuts
          4 :shellfish
          8 :strawberries
          16 :tomatoes
          32 :chocolate
          64 :pollen
          128 :cats})

(defn allergies [number]
  (map all (filter #(= (bit-and number %) %) (keys all))))

(defn allergic-to? [number allergy]
       (<= 0 (.indexOf (allergies number) allergy)))

