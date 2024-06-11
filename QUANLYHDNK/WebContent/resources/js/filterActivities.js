document.querySelector('.search-button').addEventListener('click', function() {
    // Lấy giá trị tìm kiếm và loại bỏ khoảng trắng, chuyển đổi thành chữ thường
    var searchValue = document.querySelector('.search-input').value.replace(/\s+/g, '').toLowerCase();
    var selectedValue = document.getElementById('hd-filter').value;
    var activities = document.querySelectorAll('.dshoatdong');
    
    activities.forEach(function(activity) {
        var titleId = activity.getAttribute('data-title-id');
        var activityName = activity.querySelector('.ten h3').textContent.replace(/\s+/g, '').toLowerCase();
        
        if ((selectedValue === 'all' || titleId === selectedValue) && (searchValue === '' || activityName.includes(searchValue))) {
            activity.style.display = 'flex';
        } else {
            activity.style.display = 'none';
        }
    });
});
