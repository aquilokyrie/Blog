<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	</head>
	<body>
		<nav class="navbar navbar-inverse" role="navigation">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">aquilokyrie的博客</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li><a href="#">经纬检索</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#">关于本站</a></li>
		        <li><a href="#">关于我</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="page-header">
					  <h1>文章标题 <small class="text-right">发布于2014-12-12 12:12:12 By aquilokyrie</small></h1>
					</div>
					<h1 class="note-title">JavaScript数据类型</h1>
<p class="note-tags to-remove"><i class="icon-bookmark"></i><code>学习笔记</code> <code>javascript</code> <code>前端</code> <code>markdown</code> </p>
<h3>1. javascript的基本数据类型</h3>
<ul>
<li><code>boolean</code> 布尔值,包含一个真值,取值只能为<code>true</code>或<code>false</code></li>
<li><code>number</code> 各种数字类型的统一类型,包括了<strong>整型</strong>(int,long),<strong>浮点数</strong>(float,double)和<code>NaN</code>(<strong>非数</strong>,not a number).</li>
<li><code>null</code> 对于基本型来说标识没有数据,对于对象来说,表示没有实例化,只能取唯一可取的值<code>null</code></li>
<li><code>Undefined</code> 表示对象没有被声明,只能取唯一可取的值<code>undefined</code>,但是,这种类型只能用于文档和异常中,不能用于代码中.药判断一个变量<code>x</code>是否是<code>undefined</code>,需要这样判断:<code>if(typeof x === 'undefined')</code>,其余方法不是报错就是永远返回<code>false</code>.</li>
</ul>
<p><strong>基本数据类型的隐式转换</strong>:</p>
<ul>
<li><strong>和字符串相加的结果仍然是字符串</strong>.一个数字加上<strong>空字符串</strong>就可以将数字转换为字符串</li>
<li><strong>数字和字符串相减的结果是数字</strong>.可以将一个字符串减0来转换</li>
<li>如果参与运算的字符串不能被转换为number型,将得到<code>NaN</code></li>
</ul>
<p><strong>基本数据类型的显式转换</strong>:</p>
<ul>
<li><code>Number(var)</code>:设法将参数转换为数字,参数中包含非数字字符时将返回非数.</li>
<li><code>parseFloat(var)</code>:设法将参数转换为浮点数,直到第一个非数字字符为止(可以识别小数点,而且第二个小数点会被处理为非数字字符),如果第一个字符即不是数字,那么返回非数.如果第一个字符是小数点,那么自动解析为0.xxx.</li>
<li><code>parseInt(var)</code>:设法将参数转换为整数,直到第一个非数字字符<br>如果第一个字符即不是数字,那么返回<code>NaN</code><br><strong>小数点</strong><code>.</code>也会被认为是非数字字符,所以这个函数会直接截掉小数部分而不会四舍五入,如果第一个字符就是小数点,那么同样会返回<code>NaN</code>.</li>
</ul>
<h3>2. javascript复合数据类型</h3>
<ul>
<li><p><code>object</code>:对象,<strong>对象</strong>是javascript种一个重要的概念,在js中,对象拥有:属性,方法,事件.注意与java等强类型检查语言的不同之处在于,javascript是基于对象的.</p>
<p><code>Array</code>:数组.类似于对象,数组需要使用new关键字和构造函数来创建</p>
</li>
</ul>
<pre class="hljs-dark"><code class="hljs javascript">  <span class="hljs-keyword">var</span> preInitArray = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Array</span>(<span class="hljs-string">'ddd'</span>,<span class="hljs-string">'dd'</span>,<span class="hljs-string">'dd'</span>);   <span class="hljs-comment">//指定数组的内容</span>
  <span class="hljs-keyword">var</span> preInitArray = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Array</span>(<span class="hljs-number">3</span>); <span class="hljs-comment">//指定数组的长度</span>
  <span class="hljs-keyword">var</span> preInitArray = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Array</span>(); <span class="hljs-comment">//创建一个空数组</span>
  <span class="hljs-keyword">var</span> myArray = [<span class="hljs-number">1</span>,<span class="hljs-number">2</span>,<span class="hljs-number">3</span>];           <span class="hljs-comment">//使用简写方式</span>
  anArray[<span class="hljs-number">2</span>] = <span class="hljs-string">'arrayNodeInstance'</span> <span class="hljs-comment">//使用索引改变某个数组索引对应的内容</span>
</code></pre>
<p><strong>javascript内置对象</strong>:</p>
<ul>
<li><code>Function</code>:函数类型,每个函数在调用时都会创建一个<code>Function</code>类型的实例</li>
<li><code>Object</code>:所有对象的基类</li>
<li><code>String</code>:字符串类型,String除了存储数据之外,额外包括了处理字符串的许多方法,字符串常量也可以直接使用String的成员函数,此时javascript会做出一个临时的String对象.</li>
<li><code>Array</code>:数组对象,是核心对象之一</li>
<li><code>Date</code>:日期类型</li>
<li><code>Number</code>:数值类型包装类</li>
<li><code>Math</code>:数学工具类</li>
<li><code>Boolean</code>:布尔类型包装类</li>
<li><code>RegExp</code>:正则表达式对象</li>
</ul>
<h4>2.1 字符串(String)</h4>
<p>字符串是一个字符序列,可以包含大多数ACSII字符,如果是特殊字符(包含引号或者控制字符),需要使用<strong>转义字符</strong><code>\</code>.<br>如果你使用Unicode字符,这也没有什么问题,但是在传输这个字符串时可能需要许多额外处理,使用字符串总是要注意编码的麻烦.</p>
<h5>字符串转义序列</h5>
<table>
<thead>
<tr>
<th style="text-align:center">字符</th>
<th style="text-align:center">描述</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align:center">\b</td>
<td style="text-align:center">回退</td>
</tr>
<tr>
<td style="text-align:center">\0</td>
<td style="text-align:center"><code>NUL</code>,空字符</td>
</tr>
<tr>
<td style="text-align:center">\f</td>
<td style="text-align:center">换页</td>
</tr>
<tr>
<td style="text-align:center">\n</td>
<td style="text-align:center">换行</td>
</tr>
<tr>
<td style="text-align:center">\r</td>
<td style="text-align:center">回车符</td>
</tr>
<tr>
<td style="text-align:center">\t</td>
<td style="text-align:center">制表符</td>
</tr>
<tr>
<td style="text-align:center">\v</td>
<td style="text-align:center">竖直的制表符</td>
</tr>
<tr>
<td style="text-align:center">\b</td>
<td style="text-align:center">退格</td>
</tr>
<tr>
<td style="text-align:center">\`</td>
<td style="text-align:center">单引号</td>
</tr>
<tr>
<td style="text-align:center">\"</td>
<td style="text-align:center">双引号</td>
</tr>
<tr>
<td style="text-align:center">\xNN</td>
<td style="text-align:center">NN是一个16进制数,表示拉丁字符集中的一个数</td>
</tr>
<tr>
<td style="text-align:center">\uDDDD</td>
<td style="text-align:center">DDDD是一个十六进制数,表示一个Unicode字符</td>
</tr>
</tbody>
</table>
<h5>字符串常量</h5>
<p>使用<strong>单引号</strong><code>'</code>或者<strong>双引号</strong><code>"</code>包围字符集合,单引号和双引号代表的意义是相同的,但是我们应当保持一致的编程风格. </p>
<h5>字符串创建</h5>
<p>直接给一个变量赋予字符串常量或者调用<code>String</code>构造函数.</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> myStringObjectA = <span class="hljs-keyword">new</span> <span class="hljs-built_in">String</span>();
<span class="hljs-keyword">var</span> myStringObjectB = <span class="hljs-keyword">new</span> <span class="hljs-built_in">String</span>(<span class="hljs-string">"this is a string"</span>);
<span class="hljs-keyword">var</span> myStringObjectC = <span class="hljs-keyword">new</span> <span class="hljs-built_in">String</span>(<span class="hljs-number">10000</span>);    <span class="hljs-comment">//编程字符串'10000'</span>
<span class="hljs-keyword">var</span> myStringObjectD = <span class="hljs-string">"中文 español English हिन्दी العربية português বাংলা русский 日本語 ਪੰਜਾਬੀ 한국어"</span>;
<span class="hljs-keyword">var</span> myStringObjectE = <span class="hljs-built_in">String</span>.fromCharCode(<span class="hljs-number">65</span>,<span class="hljs-number">66</span>,<span class="hljs-number">67</span>);    <span class="hljs-comment">//"ABC"</span>
<span class="hljs-keyword">if</span>(<span class="hljs-built_in">String</span>.fromCodePoint){
    <span class="hljs-keyword">var</span> myStringObjectF = <span class="hljs-built_in">String</span>.fromCodePoint(<span class="hljs-number">0x1D306</span>,<span class="hljs-number">0x61</span>,<span class="hljs-number">0x1D307</span>);
    <span class="hljs-comment">//该函数是ECMAScript6的标准,还属于草案状态,目前只有火狐浏览器支持</span>
}
</code></pre>
<h5>字符的访问</h5>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> s = <span class="hljs-string">"this is a string"</span>
<span class="hljs-built_in">document</span>.write(s.charAt(<span class="hljs-number">0</span>));
<span class="hljs-built_in">document</span>.write(s[<span class="hljs-number">0</span>]);  <span class="hljs-comment">//javascript中的字符串可以直接视为字符数组使用</span>
<span class="hljs-built_in">document</span>.write(<span class="hljs-string">"this is a string"</span>[<span class="hljs-number">0</span>]);
</code></pre>
<h5>字符串成员函数</h5>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> s = <span class="hljs-keyword">new</span> <span class="hljs-built_in">String</span>(<span class="hljs-string">'lalala'</span>);
<span class="hljs-built_in">console</span>.log(s.length)    <span class="hljs-comment">//获得字符串的长度</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"charAt:"</span>+s.charAt(<span class="hljs-number">4</span>)); <span class="hljs-comment">//获得特定索引位置的字符</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"charCodeAt:"</span>+s.charCodeAt(<span class="hljs-number">4</span>)); <span class="hljs-comment">//获得索引位置字符的编码</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"concat:"</span>+s.concat(following));  <span class="hljs-comment">//拼接字符串,返回新的字符串</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"indexOf:"</span>+s.indexOf(<span class="hljs-string">'la'</span>)); 
<span class="hljs-comment">//返回某个字符(串)第一次出现的索引位置,如果参数是字符串,则返回该子字符串第一次出现时首字符,如果不存在则返回-1,此方法也可以判断字符串中是否包含某个字符或子字符串</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"lastIndexOf'la':"</span>+s.lastIndexOf(<span class="hljs-string">'la'</span>));
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"substring'2,4':"</span>+s.substring(<span class="hljs-number">2</span>,<span class="hljs-number">4</span>));
<span class="hljs-comment">//按照索引位置取字符串,注意索引从0开始</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"substring'2':"</span>+s.substring(<span class="hljs-number">2</span>));
</code></pre>
<h4>2.2 Date 日期类型</h4>
<p>javascript中没有日期的基本类型,它必须作为对象存在.</p>
<p>日期类型最令人头痛的问题:</p>
<ol>
<li>表示同一个时间的方式用很多种,世界各地都不一样,这称为本地时间</li>
<li>国际上可以通行的标准化时间格式也不止一种,比如分为ISO8061和UTC</li>
<li>不同的软件系统(如不同的DBMS),不同的语言(如java和js)对日期类型的实现,各自日期类型提供的接口都不相同,即使你的日期数据在js里工作良好,但不能保证其他系统能够处理他们.</li>
<li>不同的软件系统和语言格式化日期的方法多种多样,表示日期格式的格式化字符串也多种多样</li>
<li>对于js来说,相同函数所给出的标准化字符串在不同浏览器中的实现不一定都相同,比如chrome和firefox的toString()方法.</li>
</ol>
<h5>2.2.1 日期对象创建</h5>
<p>创建日期对象只能使用构造函数:</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> myDate1 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>();       <span class="hljs-comment">//根据系统默认制式自动获取系统当前时间</span>
<span class="hljs-keyword">var</span> myDate2 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>(<span class="hljs-string">"1 Jan 2000 10:24:00"</span>);  <span class="hljs-comment">//注意字符串格式</span>

<span class="hljs-keyword">var</span> myDate3 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>(<span class="hljs-number">2003</span>,<span class="hljs-number">11</span>,<span class="hljs-number">27</span>,<span class="hljs-number">23</span>,<span class="hljs-number">45</span>,<span class="hljs-number">59</span>,<span class="hljs-number">230</span>);<span class="hljs-comment">//注意,因为索引从0开始,所以11表示的是12月.参数按顺序是year,month,day,hour,minute,second,msecond,不能跳跃使用,如果参数值大于合理最大值会自动进位,个别参数可以使用字符串</span>

<span class="hljs-keyword">var</span> myDate4 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>(<span class="hljs-number">200378663</span>); <span class="hljs-comment">//从1970-1-1 0:0:0:000 UTC开始的毫秒数</span>
</code></pre>
<h5>2.2.2 日期对象的成员访问</h5>
<p>一个Date对象更加像一个VO类,除了对日期数据进行包装之外,并没有进行其他过多的处理.</p>
<p>通过Date对象的<strong>getter函数</strong>访问具体时间.其中,年月日时分秒毫秒的返回值类型都是<code>number</code>.</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> myDate1 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>(<span class="hljs-number">2003</span>,<span class="hljs-number">11</span>,<span class="hljs-number">27</span>,<span class="hljs-number">23</span>,<span class="hljs-number">45</span>,<span class="hljs-number">59</span>,<span class="hljs-number">230</span>); 
<span class="hljs-built_in">console</span>.log(myDate1.getFullYear());          <span class="hljs-comment">//2003,getYear已经不被建议</span>
<span class="hljs-built_in">console</span>.log(myDate1.getMonth());             <span class="hljs-comment">//11</span>
<span class="hljs-built_in">console</span>.log(myDate1.getDate());              <span class="hljs-comment">//27</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"hours:"</span>+myDate1.getHours());    <span class="hljs-comment">//23</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"minu:"</span>+myDate1.getMinutes());   <span class="hljs-comment">//45</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"seconds:"</span>+myDate1.getSeconds());<span class="hljs-comment">//59</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"ms:"</span>+myDate1.getMilliseconds());<span class="hljs-comment">//230</span>
</code></pre>
<p>对于<strong>UTC时间</strong>,Date类型提供了另一套方法:</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-built_in">console</span>.log(myDate1.getUTCFullYear());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCMonth());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCDate());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCHours());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCMinutes());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCSeconds());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCMilliseconds());
<span class="hljs-built_in">console</span>.log(myDate1.getUTCDay());   <span class="hljs-comment">//获得星期</span>
</code></pre>
<p>Date类型的某些<strong>getter函数</strong>可以被更好地利用:</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> myDate1 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>(<span class="hljs-number">2003</span>,<span class="hljs-number">11</span>,<span class="hljs-number">27</span>,<span class="hljs-number">23</span>,<span class="hljs-number">45</span>,<span class="hljs-number">59</span>,<span class="hljs-number">230</span>); 

<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"length:"</span>+myDate1.length);
<span class="hljs-comment">//获得日期对象的长度,由于日期的实际数据存储被封装起来了,所以长度固定为7,其存储内容其实就是getTime()所得到的值!</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"time:"</span>+myDate1.getTime());
<span class="hljs-comment">//获得从1970-1-1 00:00:00:000 UTC 到date实例所代表的时间为止中间所经历的毫秒数</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"day:"</span>+myDate1.getDay());
<span class="hljs-comment">//获得星期x,类型为number,范围0-6,可以通过这个方法简单的换算星期</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"timezoneOffset:"</span>+myDate1.getTimezoneOffset());
<span class="hljs-comment">//获得以分钟为单位计量的当前时区位置,中国是-480</span>
</code></pre>
<p>Date类型的<strong>setter</strong>函数:如果参数的值超过了理论范围会自动进位.可以利用这一点方便地给一个时间加上若干天</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> myDate1 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>();
<span class="hljs-built_in">console</span>.log(myDate1.setDate(<span class="hljs-number">26</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setFullYear(<span class="hljs-number">1993</span>));     <span class="hljs-comment">//注意,和setYear不同的是,如果输入93,setFullYear会将值设定为0093年,而不是setYear的1993年.</span>
<span class="hljs-built_in">console</span>.log(myDate1.setHours(<span class="hljs-number">14</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setMilliseconds(<span class="hljs-number">987</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setMinutes(<span class="hljs-number">12</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setMonth(<span class="hljs-number">12</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setSeconds(<span class="hljs-number">12</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setTime(<span class="hljs-number">74827372</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCDate(<span class="hljs-number">12</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCFullYear(<span class="hljs-number">1984</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCHours(<span class="hljs-number">4</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCMilliseconds(<span class="hljs-number">124</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCMinutes(<span class="hljs-number">45</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCMonth(<span class="hljs-number">11</span>));
<span class="hljs-built_in">console</span>.log(myDate1.setUTCSeconds(<span class="hljs-number">12</span>));
</code></pre>
<h5>2.2.5 Date类型的其他成员函数</h5>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-comment">/////////////////////////////国际化时间///////////////////</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toDateString:"</span>+myDate1.toDateString());
<span class="hljs-comment">//以适于阅读的格式返回年月日星期字符串</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toTimeString:"</span>+myDate1.toTimeString());
<span class="hljs-comment">//以适于阅读的格式返回表示时分秒的字符串</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toString:"</span>+myDate1.toString());
<span class="hljs-comment">//重写了Object类型的方法,以字符串格式返回日期实例的完整信息,包括时分秒</span>

<span class="hljs-comment">/////////////////////////////本地时间/////////////////////</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toLocaleDateString:"</span>+myDate1.toLocaleDateString());
<span class="hljs-comment">//以当地时间格式返回代表年月日的字符串</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toLocaleTimeString:"</span>+myDate1.toLocaleTimeString());
<span class="hljs-comment">//以当地时间格式返回代表时分秒的字符串</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toLocaleString:"</span>+myDate1.toLocaleString());
<span class="hljs-comment">//以当地时间格式返回完整的时间信息,包括时分秒</span>

<span class="hljs-comment">/////////////////////////////标准化时间/////////////////////</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toUTCString:"</span>+myDate1.toUTCString());
<span class="hljs-comment">//返回使用使用UTC时区格式表示的日期对象信息</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toISOString:"</span>+myDate1.toISOString());
<span class="hljs-comment">//将日期信息输出为ISO8061格式的字符串.</span>
<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"toJSON:"</span>+myDate1.toJSON());
<span class="hljs-comment">//返回和toISOString()相同的值,但是这个函数会被JSON.stringify()自动调用</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-string">"valueOf:"</span>+myDate1.valueOf());
<span class="hljs-comment">//返回日期类型的原始数据表示,该函数返回的值永远和getTime()的返回值相同,说明了日期类型的底层数据记录方式就是保存某一时间与1970-01-01 00:00:00:000 UTC 所差距的毫秒数.</span>
</code></pre>
<h5>2.2.4 Date类型的静态方法</h5>
<p>以上介绍的都是Date类型的对象方法,可以通过<code>String.prototype.XXX</code>进行重写,而还有一些静态方法可以通过类名<code>Date</code>调用:</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> myDate1 = <span class="hljs-keyword">new</span> <span class="hljs-built_in">Date</span>();

<span class="hljs-built_in">console</span>.log(<span class="hljs-built_in">Date</span>.now());
<span class="hljs-comment">//返回当前时间距离 1 January 1970 00:00:00 UTC的毫秒数</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-built_in">Date</span>.UTC(<span class="hljs-number">2014</span>,<span class="hljs-number">12</span>,<span class="hljs-number">12</span>,<span class="hljs-number">12</span>,<span class="hljs-number">12</span>,<span class="hljs-number">12</span>,<span class="hljs-number">122</span>));
<span class="hljs-comment">//返回参数指定时间距离 1 January 1970 00:00:00 UTC 的毫秒数</span>

<span class="hljs-built_in">console</span>.log(<span class="hljs-built_in">Date</span>.parse(myDate1));
<span class="hljs-comment">//将作为参数的时间类型实例转换为距离 1 January 1970 00:00:00 UTC 的毫秒数的number类型,但是毫秒位置被截去补0了</span>
</code></pre>
<h4>2.3 Math数学类</h4>
<p>Math类不能创建对象,不能存储数据,仅提供一系列静态属性和静态方法</p>
<pre class="hljs-dark"><code class="hljs javascript"><span class="hljs-keyword">var</span> x = <span class="hljs-number">100</span>;
<span class="hljs-keyword">var</span> y = <span class="hljs-number">10</span>;
<span class="hljs-keyword">var</span> z = <span class="hljs-number">0.5</span>;
<span class="hljs-built_in">document</span>.write(

    <span class="hljs-comment">/////////////////数学常数//////////////////</span>
    <span class="hljs-string">"Math.E:"</span>+<span class="hljs-built_in">Math</span>.E+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//自然对数底,约等于 2.718.</span>
    <span class="hljs-string">"Math.LN2:"</span>+<span class="hljs-built_in">Math</span>.LN2+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//2的自然对数,约等于 0.693.</span>
    <span class="hljs-string">"Math.LN10:"</span>+<span class="hljs-built_in">Math</span>.LN10+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//10的自然对数,约等于 2.303.</span>
    <span class="hljs-string">"Math.LOG2E:"</span>+<span class="hljs-built_in">Math</span>.LOG2E+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//以2为底e的对数,约等于 1.443.</span>
    <span class="hljs-string">"Math.LOG10E:"</span>+<span class="hljs-built_in">Math</span>.LOG10E+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//以10为底e的对数,约等于 0.434.</span>
    <span class="hljs-string">"Math.PI:"</span>+<span class="hljs-built_in">Math</span>.PI+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//π,约等于 3.14159.</span>
    <span class="hljs-string">"Math.SQRT1_2:"</span>+<span class="hljs-built_in">Math</span>.SQRT1_2+<span class="hljs-string">'&lt;br /&gt;'</span>+
    <span class="hljs-comment">//1/2的算数平方根,同时也等于2的平方根的倒数,约等于 0.707.</span>
    <span class="hljs-string">"Math.SQRT2:"</span>+<span class="hljs-built_in">Math</span>.SQRT2+<span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//2的算数平方根 1.414.</span>


    <span class="hljs-string">"Math.random():"</span>+<span class="hljs-built_in">Math</span>.random() + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//返回0-1之间的随机数</span>


    <span class="hljs-comment">/////////////////3级运算//////////////////</span>
    <span class="hljs-string">"Math.abs(x):"</span>+<span class="hljs-built_in">Math</span>.abs(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//绝对值</span>
    <span class="hljs-string">"Math.exp(x):"</span>+<span class="hljs-built_in">Math</span>.exp(<span class="hljs-number">0.5</span>) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//返回自然对数的x次幂,x可以为小数</span>
    <span class="hljs-string">"Math.pow(x,y):"</span>+<span class="hljs-built_in">Math</span>.pow(x,y) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//返回x的y次幂</span>
    <span class="hljs-string">"Math.sqrt(x):"</span>+<span class="hljs-built_in">Math</span>.sqrt(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//x的算数平方根</span>
    <span class="hljs-string">"Math.log(x):"</span>+<span class="hljs-built_in">Math</span>.log(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//返回x的自然对数</span>


    <span class="hljs-comment">/////////////////三角函数//////////////////</span>
    <span class="hljs-string">"Math.cos(x):"</span>+<span class="hljs-built_in">Math</span>.cos(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//余弦</span>
    <span class="hljs-string">"Math.sin(x):"</span>+<span class="hljs-built_in">Math</span>.sin(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//正弦</span>
    <span class="hljs-string">"Math.tan(x):"</span>+<span class="hljs-built_in">Math</span>.tan(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//正切</span>
    <span class="hljs-string">"Math.acos(x):"</span>+<span class="hljs-built_in">Math</span>.acos(z) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//反余弦,参数不合理返回NaN</span>
    <span class="hljs-string">"Math.asin(x):"</span>+<span class="hljs-built_in">Math</span>.asin(z) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//反正弦,参数不合理返回NaN</span>
    <span class="hljs-string">"Math.atan(x):"</span>+<span class="hljs-built_in">Math</span>.atan(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//反正切    </span>
    <span class="hljs-string">"Math.atan2(x, y):"</span>+<span class="hljs-built_in">Math</span>.atan2(y, x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//点(x,y)的反正切,注意纵坐标在前</span>


    <span class="hljs-comment">/////////////////取整//////////////////</span>
    <span class="hljs-string">"Math.ceil(x):"</span>+<span class="hljs-built_in">Math</span>.ceil(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//取整,进一法</span>
    <span class="hljs-string">"Math.floor(x):"</span>+<span class="hljs-built_in">Math</span>.floor(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//取整,退一法</span>
    <span class="hljs-string">"Math.round(x):"</span>+<span class="hljs-built_in">Math</span>.round(x) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//取整,四舍五入</span>

    <span class="hljs-comment">/////////////////取最大最小值//////////////////</span>
    <span class="hljs-string">"Math.max([x[,y[,…]]]):"</span>+<span class="hljs-built_in">Math</span>.max(<span class="hljs-number">123</span>,<span class="hljs-string">'1234'</span>,<span class="hljs-number">4</span>,<span class="hljs-number">5</span>,<span class="hljs-number">23</span>) + <span class="hljs-string">'&lt;br /&gt;'</span> +
    <span class="hljs-comment">//返回参数表中的最大值,可以无参数,无参数时返回-Number.POSITIVE_INFINITY</span>
    <span class="hljs-string">"Math.min([x[,y[,…]]]):"</span>+<span class="hljs-built_in">Math</span>.min() + <span class="hljs-string">'&lt;br /&gt;'</span> 
    <span class="hljs-comment">//返回参数表中的最小值,可以无参数,无参数时返回Number.POSITIVE_INFINITY    </span>

    );
</code></pre>
<!-- <p>结果如下<br><img longdesc="./ScreenClip.png" type="image/png" alt="Alt text" src="blob:http://maxiang.info/8af14e14-6498-4793-99a7-b6eced82e2ea" style="border: 0; max-width: 100%;"></p> -->
				</div>
				
			
			</div><!-- end of row -->
		</div><!-- end of container-fluid -->
	
	
	
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	</body>
</html>