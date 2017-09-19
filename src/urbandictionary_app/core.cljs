(ns urbandictionary-app.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [urbandictionary-app.handlers]
            [urbandictionary-app.subs]
            [cljs-exponent.reagent :refer [text view image touchable-highlight] :as rn]))

(defn alert [title]
  (.alert rn/alert title))

(defn pressed []
  (-> (js/fetch "http://api.urbandictionary.com/v0/random")
      (.then #(.json %))
      (.then #(dispatch [:set-greeting (str (map :word (:list (js->clj % :keywordize-keys true))))]))))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [image {:source (js/require "./assets/images/cljs.png")
               :style  {:width  200
                        :height 200}}]
       [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
       [touchable-highlight {:style    {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press pressed}
        [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent rn/app-registry "main" #(r/reactify-component app-root)))
