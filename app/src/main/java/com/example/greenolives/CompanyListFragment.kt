package com.example.greenolives

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "CompanyListFragment"

class CompanyListFragment : Fragment() {

    private lateinit var companyRecyclerView: RecyclerView
    private var adapter: CompanyAdapter? = null

    private val companyListViewModel: CompanyListViewModel by lazy {
        ViewModelProviders.of(this).get(CompanyListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total companies: ${companyListViewModel.companies.size}")
    }

    companion object {
        fun newInstance(): CompanyListFragment {
            return CompanyListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_company_list, container, false)

        companyRecyclerView = view.findViewById(R.id.company_recycler_view) as RecyclerView
        companyRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()
        return view
    }

    private fun updateUI() {
        val companies = companyListViewModel.companies
        adapter = CompanyAdapter(companies)
        companyRecyclerView.adapter = adapter
    }

    private inner class CompanyHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val nameTextView: TextView = itemView.findViewById(R.id.company_name)
        val dateTextView: TextView = itemView.findViewById(R.id.company_date)

    }

    private inner class CompanyAdapter(var companies : List<Company>)
        : RecyclerView.Adapter<CompanyHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyHolder {
            val view = layoutInflater.inflate(R.layout.list_item_company, parent, false)
            return CompanyHolder(view)
        }

        override fun getItemCount() = companies.size

        override fun onBindViewHolder(holder: CompanyHolder, position: Int) {
            val company = companies[position]
            holder.apply {
                nameTextView.text = company.name
                dateTextView.text = company.dateOfIncorporation.toString()
            }
        }
    }


}