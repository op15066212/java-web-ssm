class LinkManager {
    static init() {
        var activeLinkParam = getActiveLinkParam();
        if (activeLinkParam) {
            setActiveLink(activeLinkParam);
        }

        function getActiveLinkParam() {
            // ��URL�л�ȡactiveLink����
            var urlParams = new URLSearchParams(window.location.search);
            return urlParams.get("activeLink");
        }

        function setActiveLink(linkName) {
            // �Ƴ��������ӵ�active����
            var links = document.getElementsByTagName("a");
            for (var i = 0; i < links.length; i++) {
                links[i].classList.remove("active");
            }

            // ��ָ�����Ƶ����Ӽ���active����
            var link = document.querySelector('a[href*="' + linkName + '"]');
            if (link) {
                link.classList.add("active");
            }
        }
    }
}
