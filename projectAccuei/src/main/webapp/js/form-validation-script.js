var Script = function () {
	    
    $().ready(function() {
        // validate the comment form when it is submitted
        $("#feedback_form").validate();

        // validate signup form on keyup and submit
        $("#register_form").validate({
            rules: {
            	nomservice: {
                    required: true,
                    minlength: 4
                },
            	responsiblenom: {
                    required: true,
                    minlength: 4
                },
                responsibleprenom: {
                    required: true,
                    minlength: 4
                },
                responsiblecin: {
                    required: true,
                    minlength: 5
                },
                idLogin: {
                    required: true,
                    minlength: 2
                },
                prenomLogin: {
                    required: true,
                    minlength: 4
                },
                nomLogin: {
                    required: true,
                    minlength: 4
                },
            	TypeService: {
                    required: true,
                    minlength: 4
                },
                nom: {
                    required: true,
                    minlength: 4
                },
                etat: {
                    required: true,
                    minlength: 5
                },
                prenom: {
                    required: true,
                    minlength: 4
                },
                cin: {
                    required: true,
                    minlength: 6
                },
                responsibleid: {
                    required: true,
                    minlength: 2
                },
                responsibleidConfirm: {
                    required: true,
                    minlength: 2,
                    equalTo: "#responsibleid"
                },
                idServ: {
                    required: true,
                    minlength: 2
                },
                confirm_idServ: {
                    required: true,
                    minlength: 2,
                    equalTo: "#idServ"
                },
                id: {
                    required: true,
                    minlength: 2
                },
                confirm_id: {
                    required: true,
                    minlength: 2,
                    equalTo: "#id"
                },
            },
            messages: { 
            	idLogin: {
                    required: "S'il vous plait entrer un ID .",
                    minlength: "le ID doit comporter au moins 2 caracteres.."
                },
            	prenomLogin: {
                    required: "S'il vous plait entrer un Nom ",
                    minlength: "le preNom  doit comporter au moins 4 caracteres.."
                },
            	nomLogin: {
                    required: "S'il vous plait entrer un Nom  .",
                    minlength: "le Nom  doit comporter au moins 4 caracteres.."
                },
            	nomservice: {
                    required: "S'il vous plait entrer un Nom de Service .",
                    minlength: "le Nom Service doit comporter au moins 4 caracteres.."
                },
            	responsiblenom: {
                    required: "S'il vous plait entrer un Nom de Responsible .",
                    minlength: "le Nom de Responsible doit comporter au moins 4 caracteres.."
                },
                responsibleprenom: {
                   required: "S'il vous plait entrer un Prenom de Responsible .",
                   minlength: "le prenom de Responsible doit comporter au moins 4 caracteres.."
               },
               responsiblecin: {
                   required: "S'il vous plait entrer un cin de responsible .",
                   minlength: "le cin doit comporter au moins 5 caracteres.."
               },
            	TypeService: {
                     required: "S'il vous plait entrer un Type Service.",
                     minlength: "le Type Service doit comporter au moins 4 caracteres.."
                 },
                nom: {
                    required: "S'il vous plait entrer un nom.",
                    minlength: "le nom doit comporter au moins 4 caracteres.."
                },
                etat: {
                    required: "S'il vous plait entrer un etat.",
                    minlength: "le etat doit comporter au moins 5 caracteres.."
                },
                prenom: {
                    required: "S'il vous plait entrer un prenom.",
                    minlength: "le prenom doit comporter au moins 4 caracteres..."
                },
                cin: {
                    required: "S'il vous plait entrer une cin.",
                    minlength: "la cin doit comporter au moins 6 caracteres...."
                },
                responsibleid: {
                    required: "S'il vous plait entrer un ID.",
                    minlength: "le id doit comporter au moins 2 caracteres..."
                },
                responsibleidConfirm: {
                    required: "S'il vous plait entrer un ID.",
                    minlength: "le id doit comporter au moins 2 caracteres...",
                    equalTo: "Entrez le meme ID que ci-dessus."
                },
                idServ: {
                    required: "S'il vous plait entrer un ID.",
                    minlength: "le id doit comporter au moins 2 caracteres..."
                },
                confirm_idServ: {
                    required: "S'il vous plait entrer un ID.",
                    minlength: "le id doit comporter au moins 2 caracteres...",
                    equalTo: "Entrez le meme ID que ci-dessus."
                },
                id: {
                    required: "S'il vous plait entrer un ID.",
                    minlength: "le id doit comporter au moins 2 caracteres..."
                },
                confirm_id: {
                    required: "S'il vous plait entrer un ID.",
                    minlength: "le id doit comporter au moins 2 caracteres...",
                    equalTo: "Entrez le meme ID que ci-dessus."
                },
            }
        });

        // propose username by combining first- and lastname
        $("#username").focus(function() {
            var firstname = $("#firstname").val();
            var lastname = $("#lastname").val();
            if(firstname && lastname && !this.value) {
                this.value = firstname + "." + lastname;
            }
        });

        //code to hide topic selection, disable for demo
        var newsletter = $("#newsletter");
        // newsletter topics are optional, hide at first
        var inital = newsletter.is(":checked");
        var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
        var topicInputs = topics.find("input").attr("disabled", !inital);
        // show when newsletter is checked
        newsletter.click(function() {
            topics[this.checked ? "removeClass" : "addClass"]("gray");
            topicInputs.attr("disabled", !this.checked);
        });
    });


}();