import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/model/persona';
import { User} from 'src/model/user';
import { PersonaService } from '../service/persona.service';
import { MenuItem } from 'primeng/components/common/menuitem';
import { MessageService, ConfirmationService } from 'primeng/api';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  personas: Persona[];
  cols: any[];
  options: any[];
  items: MenuItem[];
  displaySaveDialog: boolean = false;
  displayEditDialog: boolean = false;

  item: string;
  displayDelDialog: boolean = false;
  
  users: User [];

  user: User ={
    id:null,
    name: null,
    login: null,
    pass: null,
    pass_alt: null,
    mail:null
  };

  persona: Persona = {
  
    ID: null,
    nombre_producto: null,
    cantidad: null,
    fh_create: null,
    usu_create: null,
    usu_update: null
  };

  selectedPersona: Persona = {
    ID: null,
    nombre_producto: null,
    cantidad: null,
    fh_create: null,
    usu_create: null,
    usu_update: null
  };

  constructor(private personaService: PersonaService, private messageService: MessageService, private confirmService: ConfirmationService) { }

  getAll() {
    this.personaService.getAll().subscribe(
      (result: any) => {
        let personas: Persona[] = [];
        for (let i = 0; i < result.length; i++) {
          let persona = result[i] as Persona;
          personas.push(persona);
        }
        this.personas = personas;
      },
      error => {
        console.log(error);
      }
    );
  }
  selUserDDL()
  {
    debugger;
    this.personaService.UserDDL().subscribe(
      (result: any)=>{
        let users: User[] = [];
        for(let i = 0; i < result.length; i++){
          let user = result[i] as User;
          users.push(user);
        }
        this.user = this.user;
      },
      error =>{
        console.log(error);
      }
    );
  }
  showEditDialog(editar: boolean){
    if(editar){
      if(this.selectedPersona != null && this.selectedPersona.ID != null){
        this.persona = this.selectedPersona;
      }else{
        this.messageService.add({severity : 'warn', summary: "Advertencia!", detail: "Por favor seleccione un producto para editar."});
        return;
      }
    }
    this.displayEditDialog = true; 
  }

  showSaveDialog(editar: boolean) {

      this.persona = new Persona();
    this.displaySaveDialog = true;
  }
showDelDialog(eliminar: boolean){
  if (eliminar) {
    if (this.selectedPersona != null && this.selectedPersona.ID != null) {
      this.persona = this.selectedPersona;
    }else{
      this.messageService.add({severity : 'warn', summary: "Advertencia!", detail: "Por favor seleccione un producto para eliminar."});
      return;
    }
  
}
this.displayDelDialog = true;
}
  update(){
    this.personaService.update(this.persona).subscribe(
      (result: any) => {
        let persona = result as Persona;
        this.validarPersona(persona);
        this.messageService.add({ severity: 'success', summary: "Resultado", detail: "Se edito el producto correctamente." });
        this.displayEditDialog = false;
      },
      error =>{
        console.log(error);
      }
    );
  }

  save() {
    this.personaService.save(this.persona).subscribe(
      (result: any) => {
        console.log("Create---"+ result)
        let persona = result as Persona;
        this.validarPersona(persona);
        this.messageService.add({ severity: 'success', summary: "Resultado", detail: "Se guardó el producto correctamente." });
        this.displaySaveDialog = false;

      },
      error => {
        console.log(error);
      }
    );
  }

  delete(){
    if(this.selectedPersona == null || this.selectedPersona.ID == null){
      this.messageService.add({severity : 'warn', summary: "Advertencia!", detail: "Por favor seleccione un registro"});
      return;
    }
    this.confirmService.confirm({
      message: "¿Está seguro que desea eliminar el registro?",
      accept : () =>{
        this.personaService.delete(this.selectedPersona.ID).subscribe(
          (result:any) =>{
            this.messageService.add({ severity: 'success', summary: "Resultado", detail: "Se eliminó la persona con id "+result.id+" correctamente." });
            this.deleteObject(result.id);
          }
        )
      }
    })
  }

  deleteObject(id:number){
    let index = this.personas.findIndex((e) => e.ID == id);
    if(index != -1){
      this.personas.splice(index, 1);
    }
  }

  

  validarPersona(persona: Persona){
    let index = this.personas.findIndex((e) => e.ID == persona.ID);

    if(index != -1){
      this.personas[index] = persona;
    }else{
      this.personas.push(persona);

    }

  }
  
  ngOnInit() {
    this.getAll();
    this.selUserDDL();
    this.cols = [
      { field: "ID", header:"ID"},
      { field: "Nombre_Producto", header: "Producto" },
      { field: "Cantidad", header: "Cantidad" },
      { field: "Fh_create", header: "Fecha Creacion" },
      { field: "Usu_create", header: "Usuario Creo" },
    ];
    
    this.options = [
      {name: "Name", code:"ID_User"}
    ];

    this.items = [
      {
        label: "Agrega Producto",
        icon: 'pi pi-fw pi-plus',
        command: () => this.showSaveDialog(false)
      },
      {
        label: "Editar Producto",
        icon: "pi pi-fw pi-pencil",
        command: () => this.showEditDialog(true)
      },
      {
        label: "Eliminar Producto", 
        icon: "pi pi-fw pi-times",
        command: () => this.showDelDialog(true)
      }
    ]

  }

}
