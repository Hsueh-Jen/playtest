
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""
<!DOCTYPER>
<html>
<head>

<title>ezTravel project</title>
<script src='"""),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*7.66*/("""'></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->

<style>

body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td """),format.raw/*16.98*/("""{"""),format.raw/*16.99*/(""" 
	margin:0;
	padding:0;
"""),format.raw/*19.1*/("""}"""),format.raw/*19.2*/("""

body"""),format.raw/*21.5*/("""{"""),format.raw/*21.6*/("""
	//background:#A9F5F2;
"""),format.raw/*23.1*/("""}"""),format.raw/*23.2*/("""

#header"""),format.raw/*25.8*/("""{"""),format.raw/*25.9*/("""
	min-height:200px;
"""),format.raw/*27.1*/("""}"""),format.raw/*27.2*/("""

.tweetBox"""),format.raw/*29.10*/("""{"""),format.raw/*29.11*/("""
	min-height:200px;
	
"""),format.raw/*32.1*/("""}"""),format.raw/*32.2*/("""


	
/* Border Fade */

.border-fade """),format.raw/*38.14*/("""{"""),format.raw/*38.15*/("""
	display: inline-block;
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
	-webkit-transition-property: box-shadow;
	transition-property: box-shadow;
	-webkit-transform: translateZ(0);
	transform: translateZ(0);
	box-shadow: inset 0 0 0 4px #e1e1e1, 0 0 1px rgba(0, 0, 0, 0);
	/* Hack to improve aliasing on mobile/tablet devices */
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/("""

.border-fade:hover, .border-fade:focus, .border-fade:active """),format.raw/*50.61*/("""{"""),format.raw/*50.62*/("""
	box-shadow: inset 0 0 0 4px #666666, 0 0 1px rgba(0, 0, 0, 0);
"""),format.raw/*52.1*/("""}"""),format.raw/*52.2*/("""
	
</style>

<script>

$(function()"""),format.raw/*58.13*/("""{"""),format.raw/*58.14*/("""

	var url=""""),_display_(Seq[Any](/*60.12*/routes/*60.18*/.Application.getJSON())),format.raw/*60.40*/("""";
	var data = """),format.raw/*61.13*/("""{"""),format.raw/*61.14*/("""}"""),format.raw/*61.15*/(""";

	$.get( url , data , function(data)"""),format.raw/*63.36*/("""{"""),format.raw/*63.37*/("""
		
		var tweetNum = JSON.parse(data).length;//文章數量
		
		for(var i=0;i<tweetNum;i++)
		"""),format.raw/*68.3*/("""{"""),format.raw/*68.4*/("""
		
			var tweet_id_str=JSON.parse(data)[i].id_str; //蘋果新聞的文章編號
			var tweet_content=JSON.parse(data)[i].text; //蘋果新聞的內文
			var created_date=JSON.parse(data)[i].created_at; //蘋果新聞文章發文時間
			
			tweet_content=tweet_content.split("http://");
			
			var content_str="";
			content_str +="<div class ='col-sm-3 tweetBox border-fade' id_str='"+tweet_id_str+"'>";
			tweet_content[0] = tweet_content[0].replace(/\n/g, '<br>');
			content_str+="<br>"+tweet_content[0];		
			content_str+="<br>"+created_date+"</div>";
			$("#content").append(content_str);
			
		"""),format.raw/*83.3*/("""}"""),format.raw/*83.4*/("""

		$(".tweetBox").click(function(e)"""),format.raw/*85.35*/("""{"""),format.raw/*85.36*/(""" //文章訊息被點擊時會連結到twitter的文章頁面
			window.open( 'http://twitter.com/TW_nextmedia/status/'+$(this).attr("id_str"), '_blank' );
		"""),format.raw/*87.3*/("""}"""),format.raw/*87.4*/(""");
		
	"""),format.raw/*89.2*/("""}"""),format.raw/*89.3*/(""");
"""),format.raw/*90.1*/("""}"""),format.raw/*90.2*/(""");

</script>

</head>

<body>

	<div id="header" class="container navbar-inverse" style='text-align:center; padding-top:40px;'>
		<img src='"""),_display_(Seq[Any](/*99.14*/routes/*99.20*/.Assets.at("images/Twitter.png"))),format.raw/*99.52*/("""' ></img>
		<div style="font-size:80px; display:inline-block; font-family:'Microsoft JhengHei'; color:white; font-weight:bold; text-shadow: 2px 2px #000000; vertical-align: middle; margin: 0 20px 0 20px;">推特大蘋果</div>
		<img src='"""),_display_(Seq[Any](/*101.14*/routes/*101.20*/.Assets.at("images/Apple.png"))),format.raw/*101.50*/("""' ></img>
	</div>
	
	<div class="container">
		<div id="content" class="row"></div>
	</div>

</body>

</html>"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 26 16:47:43 CST 2015
                    SOURCE: D:/playtest/app/views/index.scala.html
                    HASH: 6f42b13fc0e5a059bce86294233c7737f2bb228a
                    MATRIX: 774->1|885->18|994->92|1008->98|1074->143|1544->585|1573->586|1625->611|1653->612|1686->618|1714->619|1765->643|1793->644|1829->653|1857->654|1904->674|1932->675|1971->686|2000->687|2049->709|2077->710|2142->747|2171->748|2546->1096|2574->1097|2664->1159|2693->1160|2785->1225|2813->1226|2876->1261|2905->1262|2954->1275|2969->1281|3013->1303|3056->1318|3085->1319|3114->1320|3180->1358|3209->1359|3323->1446|3351->1447|3931->2000|3959->2001|4023->2037|4052->2038|4203->2162|4231->2163|4265->2170|4293->2171|4323->2174|4351->2175|4529->2317|4544->2323|4598->2355|4865->2585|4881->2591|4934->2621
                    LINES: 26->1|29->1|35->7|35->7|35->7|44->16|44->16|47->19|47->19|49->21|49->21|51->23|51->23|53->25|53->25|55->27|55->27|57->29|57->29|60->32|60->32|66->38|66->38|76->48|76->48|78->50|78->50|80->52|80->52|86->58|86->58|88->60|88->60|88->60|89->61|89->61|89->61|91->63|91->63|96->68|96->68|111->83|111->83|113->85|113->85|115->87|115->87|117->89|117->89|118->90|118->90|127->99|127->99|127->99|129->101|129->101|129->101
                    -- GENERATED --
                */
            