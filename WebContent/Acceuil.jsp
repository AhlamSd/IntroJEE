<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <title>Acceuil</title>
        <style><%@include file="acceuil.css"%></style>
        
    </head>
     <body>
         
         <div id="emballage">
            <div id="barHaut">
                <a id="logo" href=""><img  src="https://cdn-07.9rayti.com/rsrc/cache/widen_224/uploads/2012/07/ensias.png" 
                 ></a>
                <a id="logout" href="Login?logout=1">LOGOUT</a>
            </div>
            <div id="msgBienvenue">
                Bienvenue ${sessionScope.username}, à votre espace MyBiblio
            </div>
            <section id="emballageChoix"> 
                <div class="choixOption" id="monCompte">
                    <a href="#">
                        <img src="<%=getServletContext().getContextPath()%>/imgs/iconMonCompte.png" >
                        <p>Mon Compte</p>
                    </a>
                </div>
                <div class="choixOption" id="mesInfos">
                    <a href="#">
                        <img src="<%=getServletContext().getContextPath()%>/imgs/iconMesInfos.png" alt="">
                        <p>Mes Infos</p>
                    </a>
                </div>
                <div class="choixOption" id="laboratoire">
                    <a href="#">
                        <img src="<%=getServletContext().getContextPath()%>/imgs/iconLaboratoire.svg" alt="">
                        <p>Laboratoire</p>
                    </a>
                </div>
                <div class="choixOption" id="appelProjet">
                    <a target="_self" href="GestionDocuments">
                        <img src="<%=getServletContext().getContextPath()%>/imgs/iconProjet.png" alt="">
                        <p>Appel à projets</p>
                    </a>
                </div>
            </section>
            <footer>
                <img id="imgFooter" src="<%=getServletContext().getContextPath()%>/imgs/footer.svg" alt="">
            </footer>
        </div>

        <script>
            var width = window.innerWidth
            || document.documentElement.clientWidth
            || document.body.clientWidth;

            var height = window.innerHeight
            || document.documentElement.clientHeight
            || document.body.clientHeight;
            var footer=document.getElementById("imgFooter");
            footer.style.width=width.toString() + 'px';
            //footer.style.height=(height/10).toString() + 'px';
        </script>
     </body>
</html>