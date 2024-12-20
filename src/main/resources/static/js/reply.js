// const replyService = {};
const replyService = (function() {
    const url = "/reply";
		$.ajaxSetup({
			
			contentType: "application/json; charset=utf-8"
		});

    function write(reply, callback) {
			console.log(reply);
			const data = JSON.stringify(reply);
			$.post({
					url,
					data,
			})
			.done(function(data) {
		if(callback)
			callback(data);
					
			})
    }
    function list(pno, cri, callback) {
		let reformedUrl = url + "/list/" + pno;
		if(cri && cri.lastRno) {
			reformedUrl += "/" + cri.lastRno;
			if(cri.amount) {
				reformedUrl += "/" + cri.amount;
			}		
		}
		$.getJSON(reformedUrl).done(function(data) {
			if(callback)
			callback(data);
	
		});
        
    }
    function view(rno, callback) {
		$.getJSON(url + "/" + rno).done(function(data) {
			if(callback)
			callback(data);
	
		})
        
    }
	function modify(reply, callback) {
      const data = JSON.stringify(reply);
		$.ajax(url, {
			method : 'put',
			data
		}).done(function(data) {
			if(callback)
			callback(data);						
		})
	}
	function remove(rno, callback) {
		$.ajax(url + "/" + rno, {
			method : 'delete'
		}).done(function(data) {
			if(callback)
			callback(data);
				
		})
	}
    return {write, list, view, modify, remove}
})();
