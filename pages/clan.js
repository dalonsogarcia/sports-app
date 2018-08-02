import Layout from '../components/Layout.js'
import fetch from 'isomorphic-unfetch'

const Clan = (props) => (
    <Layout>
       <h1>{props.clan.name}</h1>
    </Layout>
)

Clan.getInitialProps = async function (context) {
  const { id } = context.query
  const res = await fetch(`http://localhost:8082/api/clans/${id}`)
  const clan = await res.json()

  console.log(`Fetched clan: ${clan.name}`)

  return { clan }
}

export default Clan
