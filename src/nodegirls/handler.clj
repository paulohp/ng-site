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
          [:p {:id "subheadline"} "Proximo Evento: " [:a {:href "https://www.sympla.com.br/node-school-girl__36092"} "25 de Julho"]]]]]

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
            [:p "Nós achamos que programar é fantástico e todas devem se sentir bem vindas em nosso evento. Isto inclui a nossa expectativa de que todas as participantes sejam gentis umas as outras e respeitem o nosso " [:a {:href "https://github.com/nodeschool/belo-horizonte/blob/master/CODIGO-DE-CONDUTA.md"} "Codigo de Conduta"]]]

          ]]
      [:section {:id "help" :class "site-section section-signup"}
        [:div {:class "row"}
          [:div {:class "twelve columns animate-on-scroll" :data-scrollanimation "fadeDownIn"}
            [:h3 {:class "signup-title"} "Especialmente para elas!"]
            [:h4 {:class "signup-subtitle"} "Nosso evento é 100% dedicado para mulheres! Se você estiver interessado e não atende nosso principal requisito, não hesite e fale com a gente!"]
          ]]
        [:div {:class "row"}
          [:div {:class "eight columns centered"}
            [:div {:class "signup-form"}
              [:a {:href "https://www.sympla.com.br/node-school-girl__36092" :class "btn-side animate-on-scroll" :data-scrollanimation "fadeInLeft"} [:i {:class "icon-ticket"}] "Inscreva-se"]
            ]]]
      ]
      [:iframe {:frameborder "0" :style "border:0" :height "450" :width "100%" :src "https://www.google.com/maps/embed/v1/place?q=UNA%20-%20Campus%20Barro%20Preto%20-%20Rua%20dos%20Goitacazes%20-%20Barro%20Preto%2C%20Belo%20Horizonte%20-%20State%20of%20Minas%20Gerais%2C%20Brazil&key=AIzaSyBUOhDWXCubrzzVBRHVES8u1kyN0fQiZxA"}]

      [:section {:class "site-section"}
        [:div {:class "row"}
          [:div {:class "twelve columns animate-on-scroll" :data-scrollanimation "fadeDownIn"}
            [:h3 "Dúvidas? Sugestões?"]
            [:h4 "Abra uma issue no " [:a {:href "https://github.com/nodeschool/belo-horizonte" } "GitHub"]  " e nos ajude!"]
            [:p "Se você ainda não estiver no GitHub, crie uma  " [:a {:href "https://github.com/join"} "conta gratuita"] " e de uma olhada no " [:a {:href "http://nodeschool.io/#git-it"} "Git-it "] "workshop. Isso com certeza vai te ajudar a começar."]
          ]]
      ]]

      [:footer {:class "site-footer" :role "contentinfo"}
        [:div {:class "row footer-info"}
          [:div {:class "twelve columns"}
            [:h3 "Patrocinio: "]
            [:a {:target "_blank", :href "http://avenuecode.com"}
             [:img {:width "150", :src "http://frontinbh.com.br/images/sponsor-gold-avenue.png", :alt "Avenue Code"}] ]
          ]
          [:div {:class "twelve columns alpha"}
            [:h3 "Realização: "]
            [:a {:target "_blank", :href "http://www.minasdev.org/"}
             [:img {:width "150", :src "http://minasdev.org/assets/images/svgs/minasdev-logo.svg", :alt "MinasDev"}] ]
            [:a {:target "_blank", :href "http://www.gdgbh.org/"}
             [:img {:width "150", :src "https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xfp1/v/t1.0-9/11021194_790772184325398_1886863645796117655_n.jpg?oh=edbac5ca743c59e878caaef2e50fe067&oe=55FDD52D&__gda__=1441611684_ef4b104d5c757e202c7d920aa549a231", :alt "GDG-BH"}] ]
          ]
          [:div {:class "twelve columns alpha"}
            [:h3 "Apoio: "]
            [:a {:target "_blank", :href "http://www.digitalocean.com"}
             [:img {:width "150", :src "http://arcannia.me/wp-content/uploads/2015/04/digitalocean-square-logo-535x535.png", :alt "Digital Ocean"}] ]
            [:a {:target "_blank", :href "http://www.strongloop.com"}
             [:img {:width "150" :style "background-color:white" :src "https://upload.wikimedia.org/wikipedia/en/1/11/StrongLoop_logo.png", :alt "Strong Loop"}] ]
          ]
        ]
      ]
    ))

(defroutes app-routes
  (GET "/" [] (view-content))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
