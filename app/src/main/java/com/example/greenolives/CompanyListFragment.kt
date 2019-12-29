package com.example.greenolives

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.Drawable



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
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var company : Company
        private val nameTextView: TextView = itemView.findViewById(R.id.company_name)
        private val taglineTextView: TextView = itemView.findViewById(R.id.company_tagline)
        //private val dateTextView: TextView = itemView.findViewById(R.id.company_date)
        private val specializationTextView: TextView = itemView.findViewById(R.id.company_specialization)
        //private val ratingTextView: TextView = itemView.findViewById(R.id.company_rating)
        private val fundingStatusView: TextView? = itemView.findViewById(R.id.company_funding_status)
        private val numInvestorsTextView: TextView? = itemView.findViewById(R.id.company_num_investors)
        private val sizeTextView: TextView = itemView.findViewById(R.id.company_size)
        private val companyImageView: ImageView = itemView.findViewById(R.id.imageView2)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(company : Company) {
            this.company = company
            nameTextView.text = company.name
            taglineTextView.text = company.tagline
            //dateTextView.text = company.dateOfIncorporation.toString()
            specializationTextView.text = company.specialization
            //ratingTextView.text = company.rating.toString()
            sizeTextView.text = company.size

            val res = resources
            val resID = res.getIdentifier(company.image, "drawable", activity?.packageName)
            val drawable = res.getDrawable(resID)
            companyImageView.setImageDrawable(drawable)

            if(company.isFunded) {
                fundingStatusView?.text = company.fundingStatus
                numInvestorsTextView?.text = "${company.numInvestors} investors"
            }

        }

        override fun onClick(v: View) {
            Toast.makeText(context, "${company.name} pressed", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class CompanyAdapter(var companies : List<Company>)
        : RecyclerView.Adapter<CompanyHolder>() {

        override fun getItemViewType(position: Int): Int {
            if(companies[position].isFunded) {
                return R.layout.list_item_company_funded
            }
            return R.layout.list_item_company
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyHolder {
            val view = layoutInflater.inflate(viewType, parent, false)
            return CompanyHolder(view)
        }

        override fun getItemCount() = companies.size

        override fun onBindViewHolder(holder: CompanyHolder, position: Int) {
            val company = companies[position]
            holder.bind(company)
        }
    }
}