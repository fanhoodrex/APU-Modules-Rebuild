<?php
$sGetNews = $db->query("SELECT heading,id FROM news ORDER BY id LIMIT 10;");
if ($sGetNews->rowCount() > 0){
    while ($rGetNews = $sGetNews->fetch()){
        echo "<li class=\"list-group-item news-selection\"><a href=\"viewNews.php?id={$rGetNews['id']}\">{$rGetNews['heading']}</a></li>";
    }
}
else{
    echo "<li class=\"list-group-item news-selection\"><a href=\"javascript:void(0)l\">Unavailable latest news!</a></li>";
}
?>