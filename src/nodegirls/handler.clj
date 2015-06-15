(ns nodegirls.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:use [hiccup.core])
  )


(defn view-layout [& content]
  (html
    [:head
     [:meta {:http-equiv "Content-type" :content "text/html;charset=utf-8"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, maximum-scale=1"}]
     [:link {:rel "stylesheet" :href "css/gumby.css"}]
     [:link {:rel "stylesheet" :href "css/custom.css"}]
     [:title "NodeGirls"]]
    [:body content]))

(defn view-content []
  (view-layout
    [:header {:role "banner" :class "site-header parallax"}
      [:div {:class "row"}
        [:div {:id "header" :class "twelve columns header-intro-wrap fadeUpIn"} 
          [:h1 {:class "logo"} "NodeGirls"]
          [:p {:id "subheadline"} "Proximo Evento: " [:a {:href "http://even.tc/nodeschool-bh"} "25 de Julho"]]]]]
    
    [:main {:role "main" :class "site-main-content"}
      [:section {:id "about" :class "site-section section-features" :data-target "features"}
        [:ul {:class "row features-list"}
          [:li {:class "features-item"}
            [:span {:class "features-circle"}
              [:span {:class "features-circle-icon"}
                [:i {:class "icon-tools"}]
               ]
             ]
            [:h3 "Aprenda"]
            [:p "Aprenda a programar em Node.js conosco, desde o nível básico. Se você já souber um pouco de JavaScript, será um grande diferencial, caso contrário, fique tranquila, nós iremos ajudá-la.."]]
          [:li {:class "features-item"}
            [:span {:class "features-circle"}
              [:span {:class "features-circle-icon"}
                [:i {:class "icon-rocket"}]
               ]
             ]
            [:h3 "Auto Guiado"]
            [:p "Você passará por vários desafios auto guiados. Nada de palestras entediantes. Todos os desafios são open source e estão disponíveis online em NodeSchool.io Isto significa que você pode continuar aprendendo após o evento."]]
          
          [:li {:class "features-item"}
            [:span {:class "features-circle"}
              [:span {:class "features-circle-icon"}
                [:i {:class "icon-heart"}]
               ]
             ]
            [:h3 "Para todas"]
            [:p "Nós achamos que programar é fantástico e todas devem se sentir bem vindas em nosso evento. Isto inclui a nossa expectativa de que todas as participantes sejam gentis umas as outras e respeitem o nosso " [:a {:href "/codigo-de-conduta"} "Codigo de Conduta"]]]

          ]]
      [:section {:id "help" :class "site-section section-signup"}
        [:div {:class "row"}
          [:div {:class "twelve columns animate-on-scroll" :data-scrollanimation "fadeDownIn"}
            [:h3 {:class "signup-title"} "Especialmente para elas!"]
            [:h4 {:class "signup-subtitle"} "Nosso evento é 100% dedicado para mulheres! Se você estiver interessado e não atende nosso principal requisito, não exite e fale com a gente!"]
          ]]
        [:div {:class "row"}]
      ]]
    
    ))

(defroutes app-routes
  (GET "/" [] (view-content))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
