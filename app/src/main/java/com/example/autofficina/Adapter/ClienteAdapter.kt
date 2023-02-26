package com.example.autofficina.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.Entity.Cliente
import com.example.autofficina.R
import com.example.autofficina.Services.ClienteService.Companion.clienteList


/*class ClienteViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val nomeView: TextView
    private val cognomeView: TextView
    private val emailView: TextView

    init {
        nomeView = view.findViewById(R.id.editTextNome)
        cognomeView = view.findViewById(R.id.editTextCognome)
        emailView = view.findViewById(R.id.editTextEmail)
    }

    fun showCliente(cliente: Cliente) {
        nomeView.text = cliente.nome
        cognomeView.text = cliente.cognome
        emailView.text = cliente.email
    }

}

class ClienteAdapter(private val cliente: List<Cliente>) : RecyclerView.Adapter<ClienteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
       val template = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_cliente, parent, false)
        return ClienteViewHolder(template)


    }
    override fun getItemCount(): Int = cliente.size

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        val cliente = cliente[position]
        holder.showCliente(cliente)
    }
}*/

class ClienteAdapter : RecyclerView.Adapter<ClienteAdapter.MyViewHolder>() {

    private var clientiList = emptyList<Cliente>()
    private var listener: OnItemClickListener? = null

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

    //viene chiamato quando viene creato un nuovo ViewHolder per una riga della RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       //viene creata una nuova istanza del ViewHolder MyViewHolder e viene inserita la  view "activity_item_cliente"
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_item_cliente,parent,false))
    }

    // onBindViewHolder viene chiamato quando si desidera associare un oggetto di dati a un ViewHolder specifico
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Viene creato l'oggetto Cliente tramite la posizione
        val currentItem = clientiList[position]
        // Qui si impostano i valori delle TextView all'interno della viewholder con i dati dell'oggetto Cliente
        holder.itemView.findViewById<TextView>(R.id.textViewNome).text = currentItem.nome
        holder.itemView.findViewById<TextView>(R.id.textViewCognome).text = currentItem.cognome
        holder.itemView.findViewById<TextView>(R.id.textViewEmail).text = currentItem.email
        holder.itemView.setOnClickListener {
            listener?.onItemClick(currentItem)
        }
    }

    // getItemCount restituisce il numero totale di oggetti nella lista di dati
    override fun getItemCount(): Int {
        return clientiList.size
    }

    // setData viene utilizzato per impostare la lista di dati del cliente e notificare l'adapter dell'aggiornamento dei dati
    fun setData(clienteList: List<Cliente>) {
        this.clientiList = clienteList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(cliente: Cliente)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}

