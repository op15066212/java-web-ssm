class LinkManager {
    static init() {
        var activeLinkParam = getActiveLinkParam();
        if (activeLinkParam) {
            setActiveLink(activeLinkParam);
        }

        function getActiveLinkParam() {
            // 从URL中获取activeLink参数
            var urlParams = new URLSearchParams(window.location.search);
            return urlParams.get("activeLink");
        }

        function setActiveLink(linkName) {
            // 移除所有链接的active类名
            var links = document.getElementsByTagName("a");
            for (var i = 0; i < links.length; i++) {
                links[i].classList.remove("active");
            }

            // 给指定名称的链接加上active类名
            var link = document.querySelector('a[href*="' + linkName + '"]');
            if (link) {
                link.classList.add("active");
            }
        }
    }
}
