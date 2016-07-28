(ns robot-simulator)

(def cardinal-points [:west :north :east :south])

(defn robot [coordinates  bearing]
   {:coordinates coordinates :bearing bearing})

(defn turn-right [direction]
  (let [index (inc (.indexOf cardinal-points direction))]
    (if (= index 4)
      :west
      (nth cardinal-points index))))

(defn turn-left [direction]
  (let [index (dec (.indexOf cardinal-points direction))]
    (if (< index 0)
      :south
      (nth cardinal-points index))))

(defn change-position [robot]
  (let [string (get robot :bearing)]
    (case string
      :east (update-in robot [:coordinates :x] inc)
      :west (update-in robot [:coordinates :x] dec)
      :north (update-in robot [:coordinates :y] inc)
      :south (update-in robot [:coordinates :y] dec))))

(defn command [string robot]
  (case string
    "A" (change-position robot)
    "L" (update robot :bearing turn-left)
    "R" (update robot :bearing turn-right)))

(defn simulate [string robot]
  (loop [coll (map str string)
         result robot]
    (if (empty? coll)
      result
      (recur (rest coll)
             (command (first coll) result)))))




