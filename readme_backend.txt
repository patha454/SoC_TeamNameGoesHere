README FOR THE UNIFY BACKEND

Because I've had to write 2,000 lines of backend in 18 hours, it's kludgy, lacks any commenting, and general sucks

What you need to know:

All .java files should be complied.

Then start the localhost (backend) server with java Unify

The frontend can now use the backend to search to University APIs by issuing a GET request:

127.0.0.1:8000/?search=querry

where 'querry' is the string to find matching courses for.

The local host will return a JSON array of the matching courses.

EXAMPLE

127.0.0.1:8000/?search=design

will return:

[{
	"qualification": "Design for Technology",
	"institution": "Otago University",
	"description": " Design for Technology combines the principles of design aesthetics and innovation with an understanding of technical function, and its use in the design of modern technology products."
}, {
	"qualification": "English & Digital Design",
	"institution": "Yoobee Polytech",
	"description": " Did you know it is possible to study English at the same time as digital design? With this unique course offered only at Yoobee School of Design Auckland you will be able to improve your academic English, as well as gain the essential design skills necessary to start a career pathway in the creative industry."
}, {
	"qualification": "Digital Design – Web and Graphic",
	"institution": "Yoobee Polytech",
	"description": " This programme is totally new. Designed to meet the latest industry demands, it provides an excellent starting point for students looking to study further in the fields of Graphic Design & Web Development."
}, {
	"qualification": "Web and UX Design",
	"institution": "Yoobee Polytech",
	"description": " The internet has revolutionised the way we communicate, shop, bank, play games and share information. The pace of change is skyrocketing – and so too is the demand for talented internet professionals. Everything you see on the vast online world is made possible by web developers. The Diploma in Web and UX Design will give you the practical skills you need to make your mark in this exciting industry. "
}]

Good Luck from your backend boy,


H Paterson.